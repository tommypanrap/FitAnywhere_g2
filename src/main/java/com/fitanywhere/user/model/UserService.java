package com.fitanywhere.user.model;

import com.fitanywhere.user.model.UserVO;
import com.util.EncryptionUtil;
import com.fitanywhere.user.model.UserDAO;
import com.fitanywhere.user.model.UserDAOImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

public class UserService {

	private UserDAO userDAO;

	public UserService() {
		// 初始化 UserDAOImpl
		this.userDAO = new UserDAOImpl();
	}

//	    ===================================================

//    傳遞註冊用的資料
	public UserVO registerUser(String uNickname, String uName, String uMail, String uPassword, String uPhone,
			Integer uGender, Date uBirth) {
		UserVO userVO = new UserVO();

		// 設置 UserVO 屬性
		userVO.setuNickname(uNickname);
		userVO.setuName(uName);
		userVO.setuMail(uMail);

		// 呼叫EncryptionUtil對密碼明碼執行單向加密進入DB (如不要加密則註解這段)
		String encryptedPassword = EncryptionUtil.encryptPassword(uPassword);
		userVO.setuPassword(encryptedPassword);

//        不啟用加密密碼的明碼寫入DB(如要加密則註解這段 如果改為不加密 則後續步驟都要修改)
//        userVO.setuPassword(uPassword);	 

		userVO.setuPhone(uPhone);
		userVO.setuVerified(0); // 預設值
		userVO.setuCoach(0); // 預設值
		userVO.setuGender(uGender);
		userVO.setuBirth(uBirth);
		userVO.setuStatus(0); // 預設值
		userVO.setuRegisterdate(new Date()); // 當下伺服器時間

		// 調用 DAO 層進行數據持久化
		return userDAO.registerUser(userVO);
	}

//	    ==========================================

//	    檢查會員註冊資料(排除重複)
	public boolean checkDuplicate(String uNickname, String uPhone, String uMail) {
		return ((UserDAOImpl) userDAO).registerCheck(uNickname, uPhone, uMail);
	}

//      ==========================================
//	    將會員註冊資料暫存到Session中
	public void storeRegistrationData(HttpSession session, String uName, String uNickname, String uBirth, String uPhone,
			String uMail, String uPassword, String uGender) {
		// 將數據存儲到Session中
		session.setAttribute("uName", uName);
		session.setAttribute("uNickname", uNickname);
		session.setAttribute("uBirth", uBirth);
		session.setAttribute("uPhone", uPhone);
		session.setAttribute("uMail", uMail);
		session.setAttribute("uPassword", uPassword);
		session.setAttribute("uGender", uGender);

		// 在這裡設定驗證碼為123456
		String verificationCode = "123456";
		session.setAttribute("verificationCode", verificationCode);
	}

//      ==========================================
//	    檢查會員輸入的驗證碼是否正確
	public int checkVerificationCode(HttpSession session, String verificationCodeFromRequest) {
		String verificationCodeFromSession = (String) session.getAttribute("verificationCode");
		if (verificationCodeFromRequest != null && verificationCodeFromRequest.equals(verificationCodeFromSession)) {
			return 0; // 驗證碼一致
		} else {
			return 1; // 驗證碼不一致
		}
	}

//      ==========================================
//	    負責讀取Session資料並呼叫註冊流程完成註冊
	public UserVO triggerRegistrationProcess(HttpSession session) {
		try {
			// 從session中提取註冊資料
			String uName = (String) session.getAttribute("uName");
			String uNickname = (String) session.getAttribute("uNickname");
			String uBirth = (String) session.getAttribute("uBirth");
			String uPhone = (String) session.getAttribute("uPhone");
			String uMail = (String) session.getAttribute("uMail");
			String uPassword = (String) session.getAttribute("uPassword");
			Integer uGender = Integer.parseInt((String) session.getAttribute("uGender"));

			// 轉換uBirth從String到Date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date birthDate = sdf.parse(uBirth);

			// 調用registerUser方法
			return registerUser(uNickname, uName, uMail, uPassword, uPhone, uGender, birthDate);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("註冊流程異常!");
			// 錯誤處理
			return null;
		}
	}

//  ==========================================	
	public UserVO login(String uMail, String inputPassword) {
		UserVO user = userDAO.loginVerification(uMail);
		if (user != null && EncryptionUtil.checkPassword(inputPassword, user.getuPassword())) {
			return user; // 返回會員資料表示登錄成功
		}
		return null; // 登錄失敗
	}

//  ==========================================


}

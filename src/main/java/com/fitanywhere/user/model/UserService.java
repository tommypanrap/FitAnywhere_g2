package com.fitanywhere.user.model;

import com.fitanywhere.user.model.UserVO;
import com.fitanywhere.user.model.UserDAO;
import com.fitanywhere.user.model.UserDAOImpl;
import java.util.Date;

public class UserService {
	
	 private UserDAO userDAO;

	    public UserService() {
	        // 初始化 UserDAOImpl
	        this.userDAO = new UserDAOImpl();
	    }

//	    ===================================================
	    
	    //	    傳遞註冊用的資料
	    public UserVO registerUser(String uNickname, String uName, String uMail, 
	                                String uPassword, String uPhone, Integer uGender, Date uBirth) {
	        UserVO userVO = new UserVO();
	        
	        // 設置 UserVO 屬性
	        userVO.setuNickname(uNickname);
	        userVO.setuName(uName);
	        userVO.setuMail(uMail);
	        userVO.setuPassword(uPassword);
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
	    
//	    檢查用戶註冊資料(排除重複)
	    public boolean checkDuplicate(String uNickname, String uPhone, String uMail) {
	        return ((UserDAOImpl)userDAO).registerCheck(uNickname, uPhone, uMail);
	    }
	    
//      ==========================================
}

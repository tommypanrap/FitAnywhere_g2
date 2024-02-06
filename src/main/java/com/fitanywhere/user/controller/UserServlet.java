package com.fitanywhere.user.controller;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.fitanywhere.user.model.UserDAO;
import com.fitanywhere.user.model.UserService;
import com.fitanywhere.user.model.UserVO;

/**
 * Servlet implementation class UserServlet
 */
//@WebServlet("/UserServlet")
@MultipartConfig
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getAll".equals(action)) {
			UserDAO dao = new UserDAO();
			List<UserVO> list = dao.getAll();

			HttpSession session = req.getSession();
			session.setAttribute("list", list);

			String url = "/user/listAllUser_getFromSession.jsp";
			RequestDispatcher success = req.getRequestDispatcher(url);
			success.forward(req, res);
			return;
		}

		if ("getOneForDisplay".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("uId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入員工編號");
			}

			// Send the use back to the form, if there were errors

			Integer uId = null;
			try {
				uId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("員工編號格式不正確");
			}
//				// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/user/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			/*************************** 2.開始查詢資料 *****************************************/
			UserService uSvc = new UserService();
			UserVO userVO = uSvc.getOneUser(uId);
			if (userVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/user/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷s
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("userVO", userVO); // 資料庫取出的empVO物件,存入req
			String url = "/user/listOneUser.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);

		}
		if ("insert".equals(action)) {

			List<String> errorMsgs = new LinkedList<>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			Integer uId = null;
			try {
				uId = Integer.valueOf(req.getParameter("uId"));
			} catch (NumberFormatException e) {
				errorMsgs.add("用戶ID請填數字");
			}
			Integer moodId = null;
			try {
				moodId = Integer.valueOf(req.getParameter("moodId"));
			} catch (NumberFormatException e) {
				errorMsgs.add("心情狀態請填數字");
			}
			String uNickname;
			uNickname = req.getParameter("uNickname");
			String uNicknameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (uNickname == null || uNickname.trim().length() == 0) {
				errorMsgs.add("暱稱: 請勿空白");
			} else if (!uNickname.trim().matches(uNicknameReg)) {
				errorMsgs.add("暱稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String uName;
			uName = req.getParameter("uName");
			String uNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (uName == null || uName.trim().length() == 0) {
				errorMsgs.add("姓名: 請勿空白");
			} else if (!uName.trim().matches(uNameReg)) {
				errorMsgs.add("姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String uMail;
			String uMailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
			uMail = req.getParameter("uMail");
			if(!uMail.trim().matches(uMailRegex)) {
				errorMsgs.add("請輸入有效的電子信箱地址");
			}
			
			String uPassword;
			uPassword = req.getParameter("uPassword");
			String uPasswordRegex = "^(?=.*[A-Za-z])(?=.*\\d).{6,}$";
			if(!uPassword.matches(uPasswordRegex)) {
				errorMsgs.add("密碼至少六位數且至少包含一個英文字母");
			}
			
			
			String uPhone;
			uPhone = req.getParameter("uPhone");
			String uPhoneRegex = "^09\\d{8}$" ;
			if(!uPhone.matches(uPhoneRegex)) {
				errorMsgs.add("請輸入有效的電話號碼");
			}
//			try {
//			} catch (NumberFormatException e) {
//				errorMsgs.put("uPhone", "聯絡電話請勿空白");
//			}

			Integer uVerified = null;
			try {
				uVerified = Integer.valueOf(req.getParameter("uVerified"));
			} catch (NumberFormatException e) {
				errorMsgs.add("驗證碼請勿空白");
			}

			Integer uCoach = null;
			try {
				uCoach = Integer.valueOf(req.getParameter("uCoach"));
			} catch (NumberFormatException e) {
				errorMsgs.add("請勿空白");
			}

			String uGender;
			uGender = req.getParameter("uGender");
//			try {
//			} catch (NumberFormatException e) {
//				errorMsgs.put("uGender", "請勿空白");
//			}

			Integer uAge = null;
			try {
				uAge = Integer.valueOf(req.getParameter("uAge"));
			} catch (NumberFormatException e) {
				errorMsgs.add("年齡請勿空白");
			}

			byte[] uHeadshot = null;

			Part uHeadshotPart = req.getPart("uHeadshot");
			InputStream inputStream = uHeadshotPart.getInputStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];

			int bytesRead;
			if (inputStream.available() != 0) {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				uHeadshot = outputStream.toByteArray();
				inputStream.close();
				outputStream.close();
			}else {
				InputStream in = getServletContext().getResourceAsStream("/user/images/pic2.png");
			    uHeadshot = in.readAllBytes();
//			    prodimageBytes = new byte[in.available()];
//			    in.read(prodimageBytes);
			    in.close();
			}
//			int length;
//			while ((length = inputStream.read(buffer)) != -1) {
//				outputStream.write(buffer, 0, length);
//			}
//			uHeadshot = outputStream.toByteArray();
//
//			inputStream.close();
//			outputStream.close();

			Date uBirth = null;
			try {
				uBirth = java.sql.Date.valueOf(req.getParameter("uBirth"));
			} catch (java.lang.IllegalArgumentException e) {
				errorMsgs.add("年齡請勿空白");
			}

			Integer uStatus = null;
			try {
				uStatus = Integer.valueOf(req.getParameter("uStatus"));
			} catch (NumberFormatException e) {
				errorMsgs.add("年齡請勿空白");
			}
			String cIntro;
			cIntro = req.getParameter("cIntro");
//			try {
//			} catch (NumberFormatException e) {
//				errorMsgs.put("uAge", "年齡請勿空白");
//			}
//			Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/user/addUser.jsp");
				failureView.forward(req, res);
				return;
			}
			/*************************** 2.開始新增資料 ***************************************/
			UserService uSvc = new UserService();
			uSvc.addUser(uId, moodId, uNickname, uName, uMail, uPassword, uPhone, uVerified, uCoach, uGender, uAge,
					uHeadshot, uBirth, uStatus, cIntro);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/user/listAllUser.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}
		if ("getOneForUpdate".equals(action)) { // 來自listAllEmp.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer uId = Integer.valueOf(req.getParameter("uId"));

			/*************************** 2.開始查詢資料 ****************************************/
			UserService uSvc = new UserService();
			UserVO userVO = uSvc.getOneUser(uId);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			String param = "?uId=" + userVO.getuId() + "&moodId=" + userVO.getmoodId() + "&uNickname="
					+ userVO.getuNickname() + "&uName=" + userVO.getuName() + "&uMail=" + userVO.getuMail()
					+ "&uPassword=" + userVO.getuPassword() + "&uPhone=" + userVO.getuPhone() + "&uVerified="
					+ userVO.getuVerified() + "&uCoach=" + userVO.getuCoach() + "&uGender=" + userVO.getuGender()
					+ "&uAge=" + userVO.getuAge() + "&uHeadshot=" + userVO.getuHeadshot() + "&uBirth="
					+ userVO.getuBirth() + "&uStatus=" + userVO.getuStatus() + "&cIntro=" + userVO.getcIntro();

			
			String url = "/user/update_user.jsp" + param;
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) {
			Map<String, String> errorMsgs = new LinkedHashMap<>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			Integer uId;
			uId = Integer.valueOf(req.getParameter("uId"));
//			try {
//			} catch (NumberFormatException e) {
//				errorMsgs.put("uId", "用戶ID請填數字");
//			}
//			String uIdReg = "^[0-9]+$";
//			if (uId == null || req.getParameter("uId") == null) {
//				errorMsgs.put("uId", "用戶ID: 請勿空白");
//			}
//				else if((uIdReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.put("ename","用戶ID: 只能是數字");
//	            }
			Integer moodId;
			moodId = Integer.valueOf(req.getParameter("moodId"));
//			try {
//			} catch (NumberFormatException e) {
//				errorMsgs.put("moodId", "心情狀態請填數字");
//			}
//			if (moodId == null) {
//				errorMsgs.put("moodId", "心情狀態請勿空白");
//			}
			String uNickname;
			uNickname = req.getParameter("uNickname");
//			try {
//			} catch (Exception e) {
//				errorMsgs.put("uNickname", "暱稱請勿空白");
//			}
//				try {
//					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					errorMsgs.put("hiredate","請輸入日期");
//				}

			String uName;
			uName = req.getParameter("uName");
			System.out.println(uName);
//			try {
//			} catch (NumberFormatException e) {
//				errorMsgs.put("uName", "名字請勿空白");
//			}

			String uMail;
			uMail = req.getParameter("uMail");
//			try {
//			} catch (NumberFormatException e) {
//				errorMsgs.put("uMail", "電子信箱請勿空白");
//			}

			String uPassword;
			uPassword = req.getParameter("uPassword");
//			try {
//			} catch (NumberFormatException e) {
//				errorMsgs.put("uPassword", "密碼請勿空白");
//			}

			String uPhone;
			uPhone = req.getParameter("uPhone");
//			try {
//			} catch (NumberFormatException e) {
//				errorMsgs.put("uPhone", "聯絡電話請勿空白");
//			}

			Integer uVerified;
			uVerified = Integer.valueOf(req.getParameter("uVerified"));
//			try {
//			} catch (NumberFormatException e) {
//				errorMsgs.put("uVerified", "請勿空白");
//			}

			Integer uCoach;
			uCoach = Integer.valueOf(req.getParameter("uCoach"));
//			try {
//			} catch (NumberFormatException e) {
//				errorMsgs.put("uCoach", "請勿空白");
//			}

			String uGender;
			uGender = req.getParameter("uGender");
//			try {
//			} catch (NumberFormatException e) {
//				errorMsgs.put("uGender", "請勿空白");
//			}

			Integer uAge;
			uAge = Integer.valueOf(req.getParameter("uAge"));
//			try {
//			} catch (NumberFormatException e) {
//				errorMsgs.put("uAge", "年齡請勿空白");
//			}

			Part uHeadshotPart = req.getPart("uHeadshot");
			InputStream inputStream = uHeadshotPart.getInputStream();
//			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] uHeadshot = inputStream.readAllBytes();

			if (uHeadshot.length==0) {
				UserService uSvc =  new UserService();
				uHeadshot = uSvc.getOneUser(uId).getuHeadshot();
			}
			    inputStream.close();
			
			Date uBirth = null;
//			uBirth = Integer.valueOf(req.getParameter("uBirth"));
//			try {
//			} catch (NumberFormatException e) {
//				errorMsgs.put("uAge", "年齡請勿空白");
//			}

			Integer uStatus;
			uStatus = Integer.valueOf(req.getParameter("uStatus"));
//			try {
//			} catch (NumberFormatException e) {
//				errorMsgs.put("uAge", "年齡請勿空白");
//			}
			String cIntro;
			cIntro = req.getParameter("cIntro");
//			try {
//			} catch (NumberFormatException e) {
//				errorMsgs.put("uAge", "年齡請勿空白");
//			}
//			Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/emp/addEmp.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始修改資料 ***************************************/
			UserService uSvc = new UserService();
			UserVO userVO = uSvc.updateUser(uId, moodId, uNickname, uName, uMail, uPassword, uPhone, uVerified, uCoach,
					uGender, uAge, uHeadshot, uBirth, uStatus, cIntro);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			req.setAttribute("userVO", userVO);
			String url = "/user/listOneUser.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			Map<String, String> errorMsgs = new LinkedHashMap<>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer uId = Integer.valueOf(req.getParameter("uId"));

			/*************************** 2.開始刪除資料 ***************************************/
			UserService uSvc = new UserService();
			uSvc.deleteUser(uId);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/user/listAllUser.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}

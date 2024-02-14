package com.fitanywhere.user.controller;

import com.fitanywhere.user.model.UserService;
import com.fitanywhere.user.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user_controller")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService(); // 增加UserService實例

	public UserController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestType = request.getParameter("requestType");

		if ("registerForm".equals(requestType)) {
			holdRegisterForm(request, response);
		} else if ("verificationMail".equals(requestType)) {
			checkVerificationCode(request, response);
		}
	}

//	將註冊表單的資訊暫存到Session中
	protected void holdRegisterForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 從請求中讀取表單數據
		HttpSession session = request.getSession();
		String uName = request.getParameter("u_name");
		String uNickname = request.getParameter("u_nickname");
		String uBirth = request.getParameter("u_birth");
		String uPhone = request.getParameter("u_phone");
		String uMail = request.getParameter("u_mail");
		String uPassword = request.getParameter("u_password");
		String uGender = request.getParameter("u_gender");

		// 將數據存儲到Session中
		userService.storeRegistrationData(session, uName, uNickname, uBirth, uPhone, uMail, uPassword, uGender);

		String verificationCodeFromSession = (String) session.getAttribute("verificationCode");
		String uMailFromSession = (String) session.getAttribute("uMail");

		System.out.println("註冊資料暫存成功!");
		System.out.println("準備發送驗證碼到: " + uMailFromSession + " 驗證碼: " + verificationCodeFromSession);

	}

//  會員輸入驗證碼的比對
	protected void checkVerificationCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String verificationCodeFromRequest = request.getParameter("verificationCode");

		int verificationResult = userService.checkVerificationCode(session, verificationCodeFromRequest);

		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();

		if (verificationResult == 0) {
			// 驗證碼正確，進行註冊流程
			UserVO userVO = userService.triggerRegistrationProcess(session);
			if (userVO != null) {
				System.out.println("註冊成功");
				out.print("0"); // 驗證碼正確且註冊成功
			} else {
				System.out.println("註冊異常");
				out.print("2"); // 註冊過程中出現問題
			}
		} else {
			out.print("1"); // 驗證碼不正確
		}
	}
}

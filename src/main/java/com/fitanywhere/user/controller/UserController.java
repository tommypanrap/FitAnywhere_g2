package com.fitanywhere.user.controller;

import com.fitanywhere.user.model.UserService;
import com.fitanywhere.user.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/user_controller")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 使用 request.getParameter 來識別請求類型
		String requestType = request.getParameter("requestType");
		if ("registerForm".equals(requestType)) {
			handleRegisterForm(request, response);
		} else if ("registerCheck".equals(requestType)) {
			handleRegisterCheck(request, response);
		}
	}

	private void handleRegisterForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uNickname = request.getParameter("u_nickname");
		String uName = request.getParameter("u_name");
		String uMail = request.getParameter("u_mail");
		String uPassword = request.getParameter("u_password");
		String uPhone = request.getParameter("u_phone");
		Integer uGender = Integer.parseInt(request.getParameter("u_gender"));
		String uBirthStr = request.getParameter("u_birth");

		// 處理日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			UserService userService = new UserService();
			UserVO userVO = userService.registerUser(uNickname, uName, uMail, uPassword, uPhone, uGender,
					sdf.parse(uBirthStr));
			// 設定回應類型
			response.setContentType("text/html;charset=UTF-8");
			if (userVO != null) {
				response.getWriter().write("註冊成功");
			} else {
				response.getWriter().write("註冊失敗");
			}
		} catch (ParseException e) {
			e.printStackTrace();
			response.getWriter().write("註冊失敗，日期格式錯誤");
		}
	}

	private void handleRegisterCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fieldName = request.getParameter("fieldName");
		String value = request.getParameter("value");

		UserService userService = new UserService();
		boolean isDuplicate = false;

		switch (fieldName) {
		case "u_nickname":
			isDuplicate = userService.checkDuplicate(value, null, null);
			break;
		case "u_phone":
			isDuplicate = userService.checkDuplicate(null, value, null);
			break;
		case "u_mail":
			isDuplicate = userService.checkDuplicate(null, null, value);
			break;
		}

		response.setContentType("text/plain;charset=UTF-8");
		if (isDuplicate) {
			response.getWriter().write("duplicate");
		} else {
			response.getWriter().write("unique");
		}
	}
}

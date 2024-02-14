package com.fitanywhere.user.controller;

import com.fitanywhere.user.model.UserService;
import com.fitanywhere.user.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
			processRegisterForm(request, response);
		} else if ("registerCheck".equals(requestType)) {
			processRegisterCheck(request, response);
		}else if ("processVerificationEmail".equals(requestType)) {
	        // 調用處理發送驗證郵件的方法
	        processVerificationEmail(request, response);
	    } else if ("processVerificationCheck".equals(requestType)) {
	        // 調用處理驗證碼核對的方法
	        processVerificationCheck(request, response);
	    }
	}

	protected void processRegisterForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

	protected void processRegisterCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
	
	protected void processVerificationEmail(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    // 模擬生成驗證碼並發送郵件的過程
	    String verificationCode = "123456";
	    String email = request.getParameter("uMail");

	    // 假設這裡是發送郵件的代碼，現在僅將驗證碼保存在 session 中
	    request.getSession().setAttribute("verificationCode", verificationCode);

	    // 返回一個成功的響應給前端
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write("{\"message\":\"驗證郵件發送成功\"}");
	}

	protected void processVerificationCheck(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    // 從請求中獲取用戶輸入的驗證碼
	    String userInputCode = request.getParameter("verificationCode");

	    // 從session中獲取之前保存的驗證碼
	    String savedCode = (String) request.getSession().getAttribute("verificationCode");

	    // 比較用戶輸入的驗證碼和保存的驗證碼
	    boolean isMatch = savedCode != null && savedCode.equals(userInputCode);

	    // 返回核對結果給前端，使用數字代替原來的文字消息
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    if (isMatch) {
	        response.getWriter().write("{\"result\":1}"); // 驗證碼正確
	    } else {
	        response.getWriter().write("{\"result\":0}"); // 驗證碼錯誤
	    }
	}




	
}

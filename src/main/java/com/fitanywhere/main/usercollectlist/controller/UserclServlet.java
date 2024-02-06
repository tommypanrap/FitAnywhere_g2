package com.fitanywhere.main.usercollectlist.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;


import com.fitanywhere.main.usercollectlist.model.*;

public class UserclServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			System.out.println("getOne_For_Display有進來");
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer crid = Integer.valueOf(req.getParameter("crid"));
			System.out.println("getOne_For_Display str"+crid);
			if (crid == null  ) {
				errorMsgs.add("請輸入課程編號");
			}
			

			
//			Integer crid = Integer.valueOf(req.getParameter("crid"));
			Integer uid = Integer.valueOf(req.getParameter("uid"));
			
			System.out.println("getOne_For_Display crid:"+crid);
			//課程編號 crid
//			try {
//				crid = Integer.valueOf(str);
//			} catch (Exception e) {
//				errorMsgs.add("課程編號格式不正確");
//			}
			

			//學員編號 uid
//			try {
//				uid = Integer.valueOf(str);
//			} catch (Exception e) {
//				errorMsgs.add("課程編號格式不正確");
//			}
			

			
			/***************************2.開始查詢資料*****************************************/
			UserclService userclSvc = new UserclService();
			UserclVO userclVO = userclSvc.getOneCollect(crid,uid);
			System.out.println("查詢資料中");
			if (crid == null || uid == null) {
				errorMsgs.add("查無資料");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/collect/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("userclVO", userclVO);
			String url = "/collect/listOneCollect.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneCollect.jsp
			successView.forward(req, res);

		}
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllCollect.jsp的請求
			System.out.println("getOne_For_Update 有進來");
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
			System.out.println("準備要接受請求參數了");	
			Integer crid = Integer.valueOf(req.getParameter("crid"));
				Integer uid = Integer.valueOf(req.getParameter("uid"));
				System.out.println("servlet getOne_For_Update crid有值"+crid);
				/***************************2.開始查詢資料****************************************/
				UserclService userclSvc = new UserclService();
				UserclVO userclVO = userclSvc.getOneCollect(crid, uid);
				
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("userclVO",userclVO);
				String url = "/collect/usercl_collect_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_collect_input.jsp
				successView.forward(req, res);
			
		}
		
		if ("update".equals(action)) { // 來自update_collect_input.jsp的請求
			System.out.println("servler update有進來");
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer crid = Integer.valueOf(req.getParameter("crid"));
			Integer uid = Integer.valueOf(req.getParameter("uid"));
			
			Integer cstatus = Integer.valueOf(req.getParameter("cstatus"));
			
			System.out.println("servlet檔案 crid: "+crid );
			System.out.println("servlet檔案 cstatus: "+cstatus );
			
			UserclVO userclVO = new UserclVO();
			userclVO.setCrid(crid);
			userclVO.setUid(uid);
			userclVO.setCstatus(cstatus);
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
req.setAttribute("userclVO", userclVO); // 含有輸入格式錯誤的userclVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/collect/update_collect_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			
			/***************************2.開始修改資料*****************************************/
			UserclService userclSvc = new UserclService();
			userclVO = userclSvc.updateCollect(crid,uid,cstatus);
			
			/***************************3.修改完成,準備轉交(Send the Success view)*************/
			req.setAttribute("userclVO", userclVO);// 資料庫update成功後,正確的的userclVO物件,存入req
			String url = "/collect/listOneCollect.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 修改成功後,轉交listOneCollect.jsp
			successView.forward(req, res);
			
		}
		
		if ("insert".equals(action)) {	// 來自addCollect.jsp的請求  
			System.out.println("insert方法有進來");
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			Integer crid = Integer.valueOf(req.getParameter("crid"));
			System.out.println("insert方法中 crid:"+crid);
			Integer uid = Integer.valueOf(req.getParameter("uid"));
			Integer cstatus = 1;
			System.out.println("insert方法 uid"+ uid);
			//預設課程收藏，insert進去，狀態1代表收藏 0代表取消收藏
			
			UserclVO userclVO = new UserclVO();
			userclVO.setCrid(crid);
			userclVO.setUid(uid);
			userclVO.setCstatus(cstatus);
			
			System.out.println("這裡");
			
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("userclVO", userclVO); // 含有輸入格式錯誤的userclVO物件,也存入req
									RequestDispatcher failureView = req
											.getRequestDispatcher("/collect/addCollect.jsp");
									failureView.forward(req, res);
									return;
			}
			
			/***************************2.開始新增資料***************************************/
			UserclService userclSvc =  new UserclService();
			System.out.println("新增資料1-1");
			userclVO = userclSvc.addCollect(crid,uid,cstatus);
			
			System.out.println("新增資料1");
			
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/collect/listAllCollect.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllCollect.jsp
			successView.forward(req, res);
		}
		
		if ("delete".equals(action)) { // 來自listAllCollect.jsp
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數***************************************/
			Integer crid = Integer.valueOf(req.getParameter("crid"));
			Integer uid = Integer.valueOf(req.getParameter("uid"));
			
			/***************************2.開始刪除資料***************************************/
			UserclService userclSvc = new UserclService();
			userclSvc.deleteCollect(crid,uid);
			
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
			String url = "/collect/listAllCollect.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);

			
		}
		
	}
}

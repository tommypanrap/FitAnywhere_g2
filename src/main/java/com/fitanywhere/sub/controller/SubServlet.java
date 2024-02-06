package com.fitanywhere.sub.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fitanywhere.sub.model.SubService;
import com.fitanywhere.sub.model.SubVO;


public class SubServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String str = req.getParameter("uId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入訂閱會員ID");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				Integer uId = null;
				try {
					uId = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("僅可輸入數字");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				SubService subSvc = new SubService();
				SubVO subVO = subSvc.getOneSub(uId);
				if (subVO == null) {
					errorMsgs.add("您輸入的編號不存在");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("subVO", subVO); // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/listOneEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.�����ШD�Ѽ�****************************************/
				Integer uId = Integer.valueOf(req.getParameter("uId"));
				
				/***************************2.�}�l�d�߸��****************************************/
				SubService subSvc = new SubService();
				SubVO subVO = subSvc.getOneSub(uId);
								
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
				req.setAttribute("subVO", subVO);         // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/update_emp_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_emp_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // �Ӧ�update_emp_input.jsp���ШD
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				
				Integer suId = Integer.valueOf(req.getParameter("suId").trim());
				Integer uId = Integer.valueOf(req.getParameter("uId").trim());
				
				
				Integer coachId = null;
				String coachIdParameter = req.getParameter("coach_id");

				if (coachIdParameter != null && !coachIdParameter.trim().isEmpty()) {
				    try {
				        coachId = Integer.valueOf(coachIdParameter);
				    } catch (NumberFormatException e) {
				        errorMsgs.add("教練ID為數字");
				    }
				} else {
				    errorMsgs.add("教練ID不能為空");
				}


				
				Integer subStatus = null;
				try {
				    String subStatusStr = req.getParameter("subStatus");
				    if (subStatusStr != null && !subStatusStr.trim().isEmpty()) {
				        // 去掉字符串两端的空格，然后转换为整数
				        subStatus = Integer.valueOf(subStatusStr.trim());
				    } else {
				        errorMsgs.add("請輸入有效的訂閱狀態數字。");
				    }
				} catch (NumberFormatException e) {
				    errorMsgs.add("請輸入有效的訂閱狀態數字。");
				}

				SubVO subVO = new SubVO();
				
				subVO.setSuId(suId);
				subVO.setuId(uId);
				subVO.setCoachId(coachId);
				subVO.setSubStatus(subStatus);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
req.setAttribute("subVO", subVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/update_emp_input.jsp");
					failureView.forward(req, res);
					return; //�{�����_
				}
				
				/***************************2.�}�l�ק���*****************************************/
				SubService subSvc = new SubService();
				subVO = subSvc.updateSub(suId, uId, coachId, subStatus);
				
				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/
				req.setAttribute("subVO", subVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
				String url = "/listOneEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneEmp.jsp
				successView.forward(req, res);
		}

        if ("insert".equals(action)) { // �Ӧ�addEmp.jsp���ШD  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
				Integer uId = null;
				try {
					uId = Integer.valueOf(req.getParameter("uId").trim());
				} catch (Exception e) {
					uId = 0;
					errorMsgs.add("請輸入數字");
				}

				Integer coachId = null;
				try {
					coachId = Integer.valueOf(req.getParameter("coachId").trim());
				} catch (NumberFormatException e) {
					coachId = 0;
					errorMsgs.add("教練ID不可為空白");
				}
				
				Integer subStatus = null;
				try {
					subStatus = Integer.valueOf(req.getParameter("subStatus").trim());
				} catch (NumberFormatException e) {
					subStatus = 1;
					errorMsgs.add("訂閱狀態不可為空白");
				}
				


				SubVO subVO = new SubVO();
				subVO.setuId(uId);
				subVO.setCoachId(coachId);
				subVO.setSubStatus(subStatus);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
req.setAttribute("subVO", subVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/addEmp.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.�}�l�s�W���***************************************/
				SubService subSvc = new SubService();
				subVO = subSvc.addSub(uId, coachId, subStatus);
				
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				String url = "/listAllEmp1_byDAO.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
				successView.forward(req, res);				
		}
//		
		
		if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.�����ШD�Ѽ�***************************************/
				Integer suId = Integer.valueOf(req.getParameter("suId"));
				
				/***************************2.�}�l�R�����***************************************/
				SubService subSvc = new SubService();
				subSvc.deleteSub(suId);
				
				/***************************3.�R������,�ǳ����(Send the Success view)***********/								
				String url = "/listAllEmp1_byDAO.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);
		}
	}
}

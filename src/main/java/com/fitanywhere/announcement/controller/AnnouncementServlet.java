package com.fitanywhere.announcement.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fitanywhere.announcement.model.AnnouncementService;
import com.fitanywhere.announcement.model.AnnouncementVO;


public class AnnouncementServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			String str = req.getParameter("anId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入anId");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/Announcement/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
			Integer anId = null;
			try {
				anId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("anId格式不正確");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/Announcement/select_page.jsp");
				failureView.forward(req, res);
				return;
			}

			AnnouncementService announcementSvc = new AnnouncementService();
			AnnouncementVO announcementVO = announcementSvc.getOneAnnouncement(anId);
			if (anId == null) {
				errorMsgs.add("查無資料");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/Announcement/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
			req.setAttribute("announcementVO", announcementVO);
			String url = "/Announcement/listOneAnnouncement.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		
		
		
		
		if ("getOne_For_Update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			Integer anId = Integer.valueOf(req.getParameter("anId"));
			AnnouncementService announcementSvc = new AnnouncementService();
			AnnouncementVO announcementVO = announcementSvc.getOneAnnouncement(anId);
			req.setAttribute("announcementVO", announcementVO);
			String url = "/Announcement/update_announcement_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		if ("update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			Integer anId = Integer.valueOf(req.getParameter("anId").trim());
			Integer crId = Integer.valueOf(req.getParameter("crId").trim());
			
			
			
			Date anDate = new Date(System.currentTimeMillis());
//			Date anDate = null;
//			try {
//				anDate = Date.valueOf(req.getParameter("anDate").trim());
//			} catch (IllegalArgumentException e) {
//				anDate = new Date(System.currentTimeMillis());
//				errorMsgs.add("請輸入日期!");
//			}
			Date anEditDate = new Date(System.currentTimeMillis());
//			Date anEditDate = null;
//			try {
//				anEditDate = Date.valueOf(req.getParameter("anEditDate").trim());
//			} catch (IllegalArgumentException e) {
//				anEditDate = new Date(System.currentTimeMillis());
//				errorMsgs.add("請輸入日期!");
//			}
			String anTitle = req.getParameter("anTitle").trim();
			if (anTitle == null || anTitle.trim().length() == 0) {
				errorMsgs.add("標題請勿空白");
			}
			String anContent = req.getParameter("anContent").trim();
			if (anContent == null || anContent.trim().length() == 0) {
				errorMsgs.add("內容請勿空白");
			}
			AnnouncementVO announcementVO = new AnnouncementVO();
			announcementVO.setAnId(anId);
			announcementVO.setCrId(crId);
			announcementVO.setAnDate(anDate);
			announcementVO.setAnEditDate(anEditDate);
			announcementVO.setAnTitle(anTitle);
			announcementVO.setAnContent(anContent);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("announcementVO", announcementVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/announcement/update_announcement_input.jsp");
				failureView.forward(req, res);
				return;
			}
			AnnouncementService announcementSvc = new AnnouncementService();
			announcementVO = announcementSvc.updateAnn(anId,crId, anDate, anEditDate, anTitle, anContent);

			req.setAttribute("announcementVO", announcementVO);
			String url = "/Announcement/listOneAnnouncement.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		if ("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
//			Integer anId = Integer.valueOf(req.getParameter("anId").trim());
			Integer crid =  null;
			try {
				crid=Integer.valueOf(req.getParameter("crid").trim());
			} catch (Exception e) {
				errorMsgs.add("請輸入數字");
			}

			Date anDate = null;
			try {
				anDate = Date.valueOf(req.getParameter("andate").trim());
			} catch (IllegalArgumentException e) {
				anDate = new Date(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}
//			Date anEditDate = null;
//			try {
//				anEditDate = Date.valueOf(req.getParameter("aneditdate").trim());
//			} catch (IllegalArgumentException e) {
//				anEditDate = new Date(System.currentTimeMillis());
//				errorMsgs.add("請輸入日期!");
//			}
			String anTitle = req.getParameter("antitle").trim();
			if (anTitle == null || anTitle.trim().length() == 0) {
				errorMsgs.add("標題請勿空白");
			}
			String anContent = req.getParameter("ancontent").trim();
			if (anContent == null || anContent.trim().length() == 0) {
				errorMsgs.add("內容請勿空白");
			}
			AnnouncementVO announcementVO = new AnnouncementVO();
//			announcementVO.setCrId(anId);
			announcementVO.setCrId(crid);
			announcementVO.setAnDate(anDate);
			announcementVO.setAnEditDate(null);
//			announcementVO.setAnEditDate(anEditDate);
			announcementVO.setAnTitle(anTitle);
			announcementVO.setAnContent(anContent);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("announcementVO", announcementVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/Announcement/addAnnouncement.jsp");
				failureView.forward(req, res);
				return;
			}
			AnnouncementService announcementSvc = new AnnouncementService();
			announcementVO = announcementSvc.addAnn(crid, anDate, null, anTitle, anContent);

			String url = "/Announcement/listAllAnnouncement.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		if ("delete".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			Integer anId = Integer.valueOf(req.getParameter("anId"));
			AnnouncementService announcementSvc = new AnnouncementService();
			announcementSvc.deleteAnn(anId);
			String url = "/Announcement/listAllAnnouncement.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
	}
}

package com.fitanywhere.opinion.controller;





import com.fitanywhere.opinion.model.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OpinionServlet
 */
@WebServlet("/Opinion/opinionservlet")
public class OpinionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpinionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        OpinionService service = new OpinionService(); // 初始化OpinionService

        if ("createOpinion".equals(action)) {
            // 從請求中獲取用戶ID和意見內容
            int userId = Integer.parseInt(request.getParameter("userId"));
            String opinionTitle = request.getParameter("title");
            String opinionContext = request.getParameter("opinion");

            // 創建OpinionVO對象並設置屬性
            OpinionVO opinion = new OpinionVO();
            opinion.setUserId(userId);
            opinion.setOpTitle(opinionTitle);
            opinion.setOpContent(opinionContext);

            try {
                // 呼叫service來新增意見
                service.createOpinion(opinion);

                // 重定向到成功頁面               
                response.sendRedirect("success.html");
            } catch (Exception e) {
                // 發生錯誤時重定向到錯誤頁面                
                response.sendRedirect("error.html");
            }
            
        } else if ("replyOpinion".equals(action)) {
        	
        	
        } else if ("showOpinionHistory".equals(action)) {
        	 int userId = Integer.parseInt(request.getParameter("userID"));
        	    int pageNo = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
        	    int pageSize = 10; // 或者您可以根據需求設置其他的頁面大小

        	    OpinionDAOImpl dao = new OpinionDAOImpl();
        	    String nickName = dao.getNickNameByUserID(userId);
        	    List<OpinionVO> opinions = dao.getAllOpinionsByUserID(userId, pageNo, pageSize);
        	    int totalOpinions = dao.countOpinionsByUserID(userId);
        	    int totalPages = (totalOpinions + pageSize - 1) / pageSize;

        	    request.setAttribute("userId", userId);
        	    request.setAttribute("nickName", nickName);
        	    request.setAttribute("opinions", opinions);
        	    request.setAttribute("totalPages", totalPages);
        	    request.setAttribute("currentPage", pageNo);
        	    request.setAttribute("totalOpinions", totalOpinions);
        	    request.setAttribute("pageSize", pageSize);

        	    RequestDispatcher dispatcher = request.getRequestDispatcher("opinionhistory.jsp");
        	    dispatcher.forward(request, response);
        	
       
        } else if ("viewDetails".equals(action)) {
           
        } else {
          
            
        }
    }


}

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.user.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
   // 取得EmpServlet.java(Concroller)，第31行存入session的list物件
    List<UserVo> list = (List<UserVo>)session.getAttribute("list"); // list變數(物件)將提供page1.file的第11行取得查詢到的總筆數，再由page1.file進行分頁的需要
%>
   <%-- 以下等同第9行--%>
   <%-- <jsp:useBean id="list" scope="session" type="java.util.List<UserVo>" /> --%>

<html>
<head>
<title>用戶資料 - listAllUser_getFromSession.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有員工資料 - listAllEmp2_getFromSession.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>用戶ID</th>
		<th>心情狀態</th>
		<th>暱稱</th>
		<th>姓名</th>
		<th>Email</th>
		<th>用戶密碼</th>
		<th>連絡電話</th>
		<th>是否已驗證帳號</th>
		<th>是否開通教練資格</th>
		<th>性別</th>
		<th>年齡</th>
		<th>用戶大頭照</th>
		<th>生日</th>
		<th>會員狀態</th>
		<th>教練自介</th>
	</tr>
	<%-- <%@ include file="page1.file" %>  --%>
	<c:forEach var="userVO" items="${list}">
		<tr>
			<td>${userVO.uId}</td>
			<td>${userVO.moodId}</td>
			<td>${userVO.uNickname}</td>
			<td>${userVO.uName}</td>
			<td>${userVO.uMail}</td>
			<td>${userVO.uPassword}</td>
			<td>${userVO.uPhone}</td>
			<td>${userVO.uVerified}</td>
			<td>${userVO.uCoach}</td>
			<td>${userVO.uGender}</td>
			<td>${userVO.uAge}</td>
			<td>${userVO.uHeadshot}</td>
			<td>${userVO.uBirth}</td>
			<td>${userVO.uStatus}</td>
			<td>${userVO.cIntro}</td>
		</tr>
	</c:forEach>
</table>
<%-- <%@ include file="page2.file" %> --%>

</body>
</html>
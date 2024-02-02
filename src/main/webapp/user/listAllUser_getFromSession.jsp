<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.user.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
   // ���oEmpServlet.java(Concroller)�A��31��s�Jsession��list����
    List<UserVo> list = (List<UserVo>)session.getAttribute("list"); // list�ܼ�(����)�N����page1.file����11����o�d�ߨ쪺�`���ơA�A��page1.file�i��������ݭn
%>
   <%-- �H�U���P��9��--%>
   <%-- <jsp:useBean id="list" scope="session" type="java.util.List<UserVo>" /> --%>

<html>
<head>
<title>�Τ��� - listAllUser_getFromSession.jsp</title>

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

<h4>�����m�߱ĥ� EL ���g�k����:</h4>
<table id="table-1">
	<tr><td>
		 <h3>�Ҧ����u��� - listAllEmp2_getFromSession.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�Τ�ID</th>
		<th>�߱����A</th>
		<th>�ʺ�</th>
		<th>�m�W</th>
		<th>Email</th>
		<th>�Τ�K�X</th>
		<th>�s���q��</th>
		<th>�O�_�w���ұb��</th>
		<th>�O�_�}�q�нm���</th>
		<th>�ʧO</th>
		<th>�~��</th>
		<th>�Τ�j�Y��</th>
		<th>�ͤ�</th>
		<th>�|�����A</th>
		<th>�нm�ۤ�</th>
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
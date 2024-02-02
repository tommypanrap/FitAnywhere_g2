<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.user.model.*"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
UserVo userVo = (UserVo) request.getAttribute("userVo"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>


<html>
<head>
<title>用戶資料 - listOneUser.jsp</title>

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
	width: 600px;
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

	<h4>此頁暫練習採用 Script 的寫法取值:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>員工資料 - listOneUser.jsp</h3>
				<h4>
					<a href="select_page.jsp"><img src="images/back1.gif"
						width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
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
		<tr>
			<td><%=userVo.getuId()%></td>
			<td><%=userVo.getmoodId()%></td>
			<td><%=userVo.getuNickname()%></td>
			<td><%=userVo.getuName()%></td>
			<td><%=userVo.getuMail()%></td>
			<td><%=userVo.getuPassword()%></td>
			<td><%=userVo.getuPhone()%></td>
			<td><%=userVo.getuVerified()%></td>
			<td><%=userVo.getuCoach()%></td>
			<td><%=userVo.getuGender()%></td>
			<td><%=userVo.getuAge()%></td>
			<td><img
					src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(userVo.uHeadshot)}"
					alt="Ad Image" width="100" height="100"></td>
			<td><%=userVo.getuBirth()%></td>
			<td><%=userVo.getuStatus()%></td>
			<td><%=userVo.getcIntro()%></td>
		</tr>
	</table>

</body>
</html>
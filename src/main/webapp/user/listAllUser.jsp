<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@page import="com.user.model.*"%>
<%@ page import="java.util.Base64"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
UserService uSvc = new UserService();
List<UserVo> list = uSvc.getAll();
pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有用戶資料</title>
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
	<table id="table-1">
		<tr>
			<td>
				<h3>所有員工資料</h3>
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

				<%-- <td>${userVO.uHeadshot}</td> --%>
				<td><img
					src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(userVO.uHeadshot)}"
					alt="Ad Image" width="100" height="100"></td>

				<td>${userVO.uBirth}</td>
				<td>${userVO.uStatus}</td>
				<td>${userVO.cIntro}</td>
				<td>
					<FORM METHOD="post" ACTION="user.do" style="margin-bottom: 0px;"
						enctype="multipart/form-data">
						<input type="submit" value="修改"> <input type="hidden"
							name="uId" value="${userVO.uId}"> <input type="hidden"
							name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post" ACTION="user.do" style="margin-bottom: 0px;">
						<input type="submit" value="刪除"> <input type="hidden"
							name="uId" value="${userVO.uId}"> <input type="hidden"
							name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>
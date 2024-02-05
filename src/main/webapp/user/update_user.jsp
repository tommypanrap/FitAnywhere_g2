<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.user.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>員工資料修改</title>
<style>
  table#table-1 {
    width: 450px;
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;s
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
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>
</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>員工資料修改</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料修改:</h3>

<%-- 錯誤表列 --%>
<%-- <c:if test="${not empty errorMsgs}"> --%>
<!-- 	<font style="color:red">請修正以下錯誤:</font> -->
<!-- 	<ul> -->
<%-- 		<c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 			<li style="color:red">${message.value}</li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
<%-- </c:if> --%>

<FORM METHOD="post" ACTION="user.do" name="form1" enctype="multipart/form-data">
<table>
    <tr>
				<td>用戶ID:</td>
				<td><input type="TEXT" name="uId" value="${param.uId}"
					size="20" /></td>
				<td>${errorMsgs.uId}</td>
			</tr>
			<tr>
				<td>心情狀態:</td>
				<td><input type="TEXT" name="moodId" value="${param.moodId}"
					size="20" /></td>
				<td>${errorMsgs.moodId}</td>
			</tr>
			<tr>
				<td>暱稱:</td>
				<td><input type="TEXT" name="uNickname"
					value="${param.uNickname}"></td>
				<td>${errorMsgs.uNickname}</td>
			</tr>
			<tr>
				<td>姓名:</td>
				<td><input type="TEXT" name="uName" value="${param.uName}"
					size="45" /></td>
				<td>${errorMsgs.uName}</td>
			</tr>
			<tr>
				<td>電子信箱:</td>
				<td><input type="TEXT" name="uMail" value="${param.uMail}"
					size="45" /></td>
				<td>${errorMsgs.uMail}</td>
			</tr>
			<tr>
				<td>用戶密碼:</td>
				<td><input type="TEXT" name="uPassword"
					value="${param.uPassword}" size="45" /></td>
				<td>${errorMsgs.uPassword}</td>
			</tr>
			<tr>
				<td>聯絡電話:</td>
				<td><input type="TEXT" name="uPhone" value="${param.uPhone}"
					size="45" /></td>
				<td>${errorMsgs.uPhone}</td>
			</tr>
			<tr>
				<td>是否已驗證帳號:</td>
				<td><input type="TEXT" name="uVerified"
					value="${param.uVerified}" size="45" /></td>
				<td>${errorMsgs.uVerified}</td>
			</tr>
			<tr>
				<td>是否開通教練資格:</td>
				<td><input type="TEXT" name="uCoach" value="${param.uCoach}"
					size="45" /></td>
				<td>${errorMsgs.uCoach}</td>
			</tr>
			<tr>
				<td>性別:</td>
				<td><select size="1" name="uGender">
						<option value="女" ${(param.uGender == '女') ? 'selected' : ''}>女</option>
						<option value="男" ${(param.uGender == '男') ? 'selected' : ''}>男</option>
						<option value="多元性別"
							${(param.uGender == '多元性別') ? 'selected' : ''}>多元性別</option>
				</select></td>

			</tr>
			<tr>
				<td>年齡:</td>
				<td><input type="TEXT" name="uAge" value="${param.uAge}"
					size="5" /></td>
				<td>${errorMsgs.uAge}</td>
			</tr>
			
			<tr>
				<td>用戶大頭照:</td>
				<td><input type="file" name="uHeadshot" 
					value="${param.uHeadshot}" size="45" /></td>
				<td>${errorMsgs.uHeadshot}</td>
				<!-- <td><INPUT type="submit" value="上傳"></td> -->
			</tr>
			<tr>
				<td>生日:</td>
				<td><input type="TEXT" name="uBirth" value="${param.uBirth}"
					size="45" /></td>
				<td>${errorMsgs.uBirth}</td>
			</tr>
			<tr>
				<td>會員狀態:</td>
				<td><input type="TEXT" name="uStatus" value="${param.uStatus}"
					size="45" /></td>
				<td>${errorMsgs.uStatus}</td>
			</tr>
			<tr>
				<td>教練自介:</td>
				<td><textarea name="cIntro" rows="4" cols="45"
						style="resize: none;">${param.cIntro}</textarea></td>
				<td>${errorMsgs.cIntro}</td>

</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="uId" value="${param.uId}">
<input type="submit" value="送出修改"></FORM>

</body>
</html>
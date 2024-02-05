<%@ page contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>AdCarousel Order</title>

<style>
table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 3px ridge Gray;
	height: 80px;
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
</head>

<body bgcolor='white'>

	<table id='table-1'>
		<tr>
			<td><h3>這是廣告訂單查詢頁面</h3></td>
		</tr>
	</table>
	<h3>資料查詢:</h3>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message.value}</li>
			</c:forEach>
		</ul>
	</c:if>

	<ul>
		<li><a href='listAllAdc.jsp'>List</a> all AdCarousel Order <br>
			<br></li>

		<li><form method="post" action="Adc.do">
				<b>輸入廣告訂單編號(如1):</b> <input type="text" name="adcId"
					value="${param.adcId}"> <font color="red">${errorMsgs.adcId}</font>
				<input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</form></li>

		<jsp:useBean id="adcSvc" scope="page"
			class="com.adcarouselorder.model.AdCarouselOrderService" />


		<li>
			<FORM method="post" action="Adc.do">
				<b>選擇廣告訂單編號:</b> <select size="1" name="adcId">
					<c:forEach var="adcVO" items="${adcSvc.all}">
						<option value="${adcVO.adcId}">${adcVO.adcId}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</form>

		</li>
		<li>
			<form method="post" action="Adc.do">
				<b>選擇廣告訂單編號:</b> <select size="1" name="adcId">
					<c:forEach var="adcVO" items="${adcSvc.all}">
						<option value="${adcVO.adcId}">${adcVO.adcId}</option>
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</form>
		</li>
	</ul>

	<h3>廣告訂單管理</h3>

	<ul>
		<li><a href='addAdc.jsp'>Add</a> a new ad.</li>
	</ul>


</body>
</html>
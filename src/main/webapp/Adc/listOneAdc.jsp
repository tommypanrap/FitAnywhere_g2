<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.fitanywhere.adcarouselorder.model.*"%>
<%@ page import="java.util.*"%>



<html>
<head>
<title>廣告資料</title>
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

img {
	max-width: 100%;
	max-height: 100%;
}
</style>
</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>員工資料 - listOneEmp.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

	<c:if test="${not empty adcVO}">
		<table>
			<tr>
				<th>輪播廣告編號</th>
				<th>廣告編號</th>
				<th>購買人</th>
				<th>被投放的廣告課程</th>
				<th>廣告開始時間</th>
				<th>廣告結束時間</th>
				<th>廣告總花費金額</th>
				<th>廣告實際結束時間</th>
				<th>廣告影片縮圖</th>
			</tr>
			<tr>
				<td>${adcVO.adcId}</td>
				<td>${adcVO.adId}</td>
				<td>${adcVO.uId}</td>
				<td>${adcVO.crId}</td>
				<td>${adcVO.adcStartDate}</td>
				<td>${adcVO.adcEndDate}</td>
				<td>${adcVO.adcTotalPrice}</td>
				<td>${adcVO.adcOrderEnddate}</td>

				<td>
				<img
					src="data:image/jpeg;base64,${fn:escapeXml(imageData)}"
					alt="Ad Image">
<!-- 				<br><img src=\""+req.getContextPath()+saveDirectory+"/"+filename+"\"> -->
					</td>
			</tr>
		</table>

	</c:if>

	<a href="select_page.jsp"><button>回首頁</button></a>

</body>
</html>

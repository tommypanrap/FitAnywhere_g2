<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.fitanywhere.main.usercollectlist.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
	UserclVO userclVO = (UserclVO) request.getAttribute("userclVO"); //UserclServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>查詢的收藏課程 - listOneCollect.jsp</title>

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
	<tr><td>
		 <h3>收藏課程(課程,學員) - listOneCollect.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>課程編號</th>
		<th>學員編號</th>
		<th>課程收藏狀態(1代表收藏 0代表取消收藏)</th>
	</tr>
	<tr>
		<td><%=userclVO.getCrid()%></td>
		<td><%=userclVO.getUid()%></td>
		<td><%=userclVO.getCstatus()%></td>
	</tr>
</table>

</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.sub.model.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
SubVO subVO = (SubVO) request.getAttribute("subVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>

<html>
<head>
<title>�q�\�|����� - listOneEmp.jsp</title>

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

<h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4>
<table id="table-1">
	<tr><td>
		 <h3>�q�\�|����� - listOneEmp.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="image/Island trapped Tom.jpg" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�q�\�|��ID</th>
		<th>�|��ID</th>
		<th>�нmID</th>
		<th>�q�\���A</th>

	</tr>
	<tr>
		<td><%=subVO.getSuId()%></td>
		<td><%=subVO.getuId()%></td>
		<td><%=subVO.getCoachId()%></td>
		<td><%=subVO.getSubStatus()%></td>
	</tr>
</table>

</body>
</html>
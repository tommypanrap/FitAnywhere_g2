<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.fitanywhere.main.usercollectlist.model.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
	UserclVO userclVO = (UserclVO) request.getAttribute("userclVO"); //UserclServlet.java(Concroller), �s�Jreq��empVO����
%>

<html>
<head>
<title>�d�ߪ����ýҵ{ - listOneCollect.jsp</title>

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
		 <h3>���ýҵ{(�ҵ{,�ǭ�) - listOneCollect.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�ҵ{�s��</th>
		<th>�ǭ��s��</th>
		<th>�ҵ{���ê��A(1�N���� 0�N���������)</th>
	</tr>
	<tr>
		<td><%=userclVO.getCrid()%></td>
		<td><%=userclVO.getUid()%></td>
		<td><%=userclVO.getCstatus()%></td>
	</tr>
</table>

</body>
</html>
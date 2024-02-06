<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.fitanywhere.main.usercollectlist.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
	UserclService userclSvc = new UserclService();
    List<UserclVO> list = userclSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>�Ҧ��ҵ{���� - listAllCollect.jsp</title>

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
		 <h3>�Ҧ����u��� - listAllEmp.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�ҵ{�s��</th>
		<th>�ǭ��s��</th>
		<th>���ê��A</th>
		
	</tr>
	
	<c:forEach var="userclVO" items="${list}"  >
		
		<tr>
			<td>${userclVO.crid}</td>
			<td>${userclVO.uid}</td>
			<td>${userclVO.cstatus}</td>
			
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/collect/collect.do" style="margin-bottom: 0px;">
			     <input type="submit" value="�ק�">
			     <input type="hidden" name="crid"  value="${userclVO.crid}">
			     <input type="hidden" name="uid"  value="${userclVO.uid}">
			     <input type="hidden" name="cstatus"  value="${userclVO.cstatus}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/collect/collect.do" style="margin-bottom: 0px;">
			     <input type="submit" value="�R��">
			     <input type="hidden" name="crid"  value="${userclVO.crid}">
			     <input type="hidden" name="uid"  value="${userclVO.uid}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>


</body>
</html>
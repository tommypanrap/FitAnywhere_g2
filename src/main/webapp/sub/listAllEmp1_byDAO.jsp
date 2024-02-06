<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sub.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
SubDAO dao = new SubDAO();
List<SubVO> list = dao.getAll(); // ���檺list�ܼ�(����)�N����page1.file����11����o�d�ߨ쪺�`���ơA�A��page1.file�i��������ݭn
pageContext.setAttribute("list", list); // �N�W�@�檺list�ܼ�(����)�s�J��e����pageContext�A�A�ѩ��U����73���JSTL��forEach�C�L�X���G
%>


<html>
<head>
<title>�Ҧ��q�\�|����� - listAllEmp1_byDAO.jsp</title>

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
		<tr>
			<td>
				<h3>�Ҧ��q�\�|����� - listAllEmp1_byDAO.jsp</h3>
				<h4>
					<a href="select_page.jsp"><img src="image/Island trapped Tom.jpg"
						width="100" height="32" border="0">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>�q�\�|��ID</th>
			<th>�|��ID</th>
			<th>�нmID</th>
			<th>�q�\���A</th>
		</tr>
		<%@ include file="page1.file"%>
		<c:forEach var="subVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">
			<tr>
				<td>${subVO.suId}</td>
				<td>${subVO.uId}</td>
				<td>${subVO.coachId}</td>
				<td>${subVO.subStatus}</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/emp.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="�ק�"> <input type="hidden"
							name="uId" value="${subVO.uId}"> <input type="hidden"
							name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/emp.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="�R��"> <input type="hidden"
							name="suId" value="${subVO.suId}"> <input type="hidden"
							name="action" value="delete">
					</FORM>
				</td>
			</tr>>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>
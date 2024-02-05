<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM Sub: Home</title>

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

<table id="table-1">
   <tr><td><h3>IBM Sub: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM Sub: Home</p>

<h3>��Ƭd��:</h3>
	
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllEmp1_byDAO.jsp'>List</a> all Subs    <h4>(byDAO).         </h4></li>
  <br>
  
  <li>
    <FORM METHOD="post" ACTION="emp.do" >
        <b>��J�q�\�|��ID (�p1):</b>
        <input type="text" name="uId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">                   <h4>(��Ʈ榡����  by Controller ).</h4> 
    </FORM>
  </li>
 

  <jsp:useBean id="subSvc" scope="page" class="com.sub.model.SubDAO" />
<%--   <% --%>
  
<%--    com.sub.model.SubDAO dao = new com.sub.model.SubDAO();pageContext.setAttribute("dao", dao); %> --%>
  <li>
     <FORM METHOD="post" ACTION="emp.do" >
       <b>��ܭq�\�|��ID:</b>
       <select size="1" name="uId">
         <c:forEach var="subVO" items="${subSvc.all}" > 
          <option value="${subVO.uId}">${subVO.uId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
  
</ul>


<h3>���u�޲z</h3>

<ul>
  <li><a href='addEmp.jsp'>Add</a> a new Emp.</li>
</ul>


<script>    
   function fun1(){
      with(document.form1){
         if (empno.value=="") 
             alert("�п�J���u�s��!");
         else if (isNaN(empno.value)) 
             alert("�s���榡�����T!");
         else if ((empno.value < 7001) || (empno.value > 7999)) 
             alert("�ж�g����7001�M7999�������ƶq!");
         else
             submit();
      }
   }
</script>

</body>
</html>
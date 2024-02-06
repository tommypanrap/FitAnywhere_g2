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

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
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
        <b>輸入訂閱會員ID (如1):</b>
        <input type="text" name="uId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">                   <h4>(資料格式驗證  by Controller ).</h4> 
    </FORM>
  </li>
 

  <jsp:useBean id="subSvc" scope="page" class="com.sub.model.SubDAO" />
<%--   <% --%>
  
<%--    com.sub.model.SubDAO dao = new com.sub.model.SubDAO();pageContext.setAttribute("dao", dao); %> --%>
  <li>
     <FORM METHOD="post" ACTION="emp.do" >
       <b>選擇訂閱會員ID:</b>
       <select size="1" name="uId">
         <c:forEach var="subVO" items="${subSvc.all}" > 
          <option value="${subVO.uId}">${subVO.uId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
</ul>


<h3>員工管理</h3>

<ul>
  <li><a href='addEmp.jsp'>Add</a> a new Emp.</li>
</ul>


<script>    
   function fun1(){
      with(document.form1){
         if (empno.value=="") 
             alert("請輸入員工編號!");
         else if (isNaN(empno.value)) 
             alert("編號格式不正確!");
         else if ((empno.value < 7001) || (empno.value > 7999)) 
             alert("請填寫介於7001和7999之間的數量!");
         else
             submit();
      }
   }
</script>

</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM Emp: Home</title>

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
   <tr><td><h3>Fitanywhere 用戶: Home</h3><h4>( MVC )</h4></td></tr>
</table>



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
  <li><a href='listAllUser.jsp'>List</a> all User    <h4>(byDAO).         </h4></li>
  <li><a href='user.do?action=getAll'> List</a> all User    <h4>(getFromSession).</h4> <br><br><br></li>
  
 <li>
    <FORM METHOD="post" ACTION="user.do" >
        <b>輸入用戶ID (如101):</b>
        <input type="text" name="uId">
        <input type="hidden" name="action" value="getOneForDisplay">
        <input type="submit" value="送出">                   <h4>(資料格式驗證  by Controller ).</h4> 
    </FORM>
  </li>
  
  <li>
    <FORM METHOD="post" ACTION="user.do" name="form1">
        <b>輸入用戶ID (如101):</b>
        <input type="text" name="uId">
        <input type="hidden" name="action" value="getOneForDisplay">
        <input type="submit" value="送出" onclick="fun1()">  <h4>(資料格式驗證  by Java Script).</h4> 
    </FORM>
  </li>

  <jsp:useBean id="dao" scope="page" class="com.user.model.UserDAO" />
   
  <li>
     <FORM METHOD="post" ACTION="user.do" >
       <b>選擇用戶ID:</b>
       <select size="1" name="uId">
         <c:forEach var="userVO" items="${dao.all}" > 
          <option value="${userVO.uId}">${userVO.uId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOneForDisplay">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="user.do" >
       <b>選擇用戶姓名:</b>
       <select size="1" name="uId">
         <c:forEach var="userVO" items="${dao.all}" > 
          <option value="${userVO.uId}">${userVO.uName}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOneForDisplay">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>
<h3>用戶管理</h3>

<ul>
  <li><a href='addUser.jsp'>新增用戶</a></li>
</ul>


<script>    
   function fun1(){
      with(document.form1){
         if (uId.value=="") 
             alert("請輸入用戶ID!");
         else if (isNaN(uId.value)) 
             alert("用戶ID格式不正確!");
         else if ((uId.value < 101) || (uId.value > 999)) 
             alert("請輸入用戶ID(三位數字)");
         else
             submit();
      }
   }
</script>

</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM Announcement: Home</title>

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
   <tr><td><h3>IBM Announcement: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM Announcement : Home</p>

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
  <li><a href='listAllAnnouncement.jsp'>List</a> all Announcements.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="announcement.do" >
        <b>��J�ҵ{���i�s�� (�paa7001):</b>
        <input type="text" name="anId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>

  <jsp:useBean id="announcementSvc" scope="page" class="com.fitanywhere.announcement.model.AnnouncementService" />
   
  <li>
     <FORM METHOD="post" ACTION="announcement.do" >
       <b>��ܽҵ{���i�s��:</b>
       <select size="1" name="anId"> 
         <c:forEach var="announcementVO" items="${announcementSvc.all}" > 
          <option value="${announcementVO.anId}">${announcementVO.anId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="announcement.do" >
       <b>��ܽҵ{�s��:</b>
       <select size="1" name="anId">
         <c:forEach var="announcementVO" items="${announcementSvc.all}" > 
          <option value="${announcementVO.anId}">${announcementVO.crId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
     </FORM>
  </li>
</ul>


<h3>���u�޲z</h3>

<ul>
  <li><a href='addAnnouncement.jsp'>Add</a> a new Announcement.</li>
</ul>

</body>
</html>
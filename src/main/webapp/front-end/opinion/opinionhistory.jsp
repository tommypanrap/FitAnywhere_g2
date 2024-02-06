<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.fitanywhere.opinion.model.OpinionVO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>歷史意見查詢</title>
    <script>
        function goToPage(pageNumber) {
            document.getElementById('pageInput').value = pageNumber;
            document.getElementById('paginationForm').submit();
        }
    </script>
</head>
<body>
    <h1>歷史意見查詢</h1>
    <p>用戶ID: ${userId}</p>
    <p>用戶暱稱: ${nickName}</p>
    
    <!-- 新增顯示意見總筆數和本頁顯示範圍 -->
    <p>意見總筆數: ${totalOpinions}</p>
    <p>本頁顯示第 ${currentPage * pageSize - (pageSize - 1)} ~ ${currentPage * pageSize < totalOpinions ? currentPage * pageSize : totalOpinions} 筆意見</p>
    
    <table>
        <tr>
            <th>意見編號</th>
            <th>意見標題</th>
            <th>意見送出時間</th>
            <th>意見狀態</th>
        </tr>
        <c:forEach var="opinion" items="${opinions}">
            <tr>
                <td>${opinion.opId}</td>
                <td>${opinion.opTitle}</td>
                <td><fmt:formatDate value="${opinion.opSendTime}" pattern="yyyy-MM-dd HH:mm"/></td>
                <td>${opinion.opStatus == 0 ? "處理中" : "已處理" }</td>
            </tr>
        </c:forEach>
    </table>
    <br>

    <!-- 分頁控制 -->
    <c:if test="${totalPages > 1}">
        <div>
            <a href="#" onclick="goToPage(${currentPage - 1})" ${currentPage == 1 ? 'style="pointer-events: none; color: grey;"' : ''}>上一頁</a>
            <span>頁數: ${currentPage}</span>
            <a href="#" onclick="goToPage(${currentPage + 1})" ${currentPage == totalPages ? 'style="pointer-events: none; color: grey;"' : ''}>下一頁</a>
        </div>
    </c:if>

    <!-- 隱藏的表單用於 POST 請求 -->
    <form id="paginationForm" action="opinionservlet" method="post" style="display: none;">
        <input type="hidden" name="action" value="showOpinionHistory">
        <input type="hidden" name="userID" value="${userId}">
        <input type="hidden" name="page" id="pageInput">
    </form>

    <br>
    <a href="index.jsp">回首頁</a>
</body>
</html>

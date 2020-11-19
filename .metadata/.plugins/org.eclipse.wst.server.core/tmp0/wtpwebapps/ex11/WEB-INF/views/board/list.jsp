<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<title>Insert title here</title>
<style>
a {text-decoration:none; color:purple;}
.active{color:red;}
</style>
</head>
<body>
<h1>[게시판 목록]</h1>
<a href="insert">글쓰기</a>
<form  name="frm">
  <input type="hidden" name="page" value="0">
</form>
 
 <table border=1>
    <tr>
        <td width=50>No.</td>
        <td width=200>제목</td>
        <td width=100>글쓴이</td>
        <td width=250>등록일</td>
    </tr>
    <c:forEach items="${list}" var="vo">
    <tr>
    <td>${vo.rn}</td>
    <td><a href="read?bno=${vo.bno}">${vo.title}</a></td>
    <td>${vo.writer}</td>
    <td><fmt:formatDate value="${vo.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
    </tr>
     </c:forEach>
    
 </table>
 
<div id="pagination">
      <c:if test="${pm.prev}">
         <a href="${pm.startPage-1}">◀</a>
      </c:if>
      <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
         <c:if test="${pm.cri.page==i}">
            [<a href="${i}" class="active">${i}</a>]
         </c:if>   
         <c:if test="${pm.cri.page!=i}">
            [<a href="${i}">${i}</a>]
         </c:if>
      </c:forEach>
      <c:if test="${pm.next}">
         <a href="${pm.endPage+1}">▶</a>
      </c:if>
   </div>

     
 
</body>

 <script>
  $("#pagination a").click(function(e){
	  e.preventDefault();
	  $(frm.page).val($(this).attr("href"));
	  frm.submit();
  });
 
 </script>
</html>
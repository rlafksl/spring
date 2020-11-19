<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>통장내역</title>
		<style>
			.title{background:gray; color:white; text-align:center;}
		</style>
</head>
<body>
		<h1>[통장내역]</h1>
		<table border=1>
			<tr>
				<td width=100 class="title">계좌번호</td>
				<td width=100> ${vo.ano}</td>
				<td width=100 class="title">성명</td>
				<td width=100>${vo.name }</td>
				<td width=100 class="title">잔액</td>
				<td width=100>${vo.balance }</td>
			
			</tr>
		
		</table>
		<div id="divTrade" style="width:600px;margin:10px 0px 10px 0px; border:solid 1px black;padding:10px;">
		계좌번호:
		<select>
			<c:forEach items="${list }" var="v">
				<c:if test="${vo.ano != v.ano }"> 
					<option>${v.ano}-${v.name}</option>
				</c:if>
				<option>${v.ano}-${v.name }</option>
			</c:forEach>
		
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		이체금액:
		<input type="text" size=5>원
		<button>이체</button>
		
		</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" href = "../resources/home.css">
<title>사용자 목록</title>
</head>
<body>
	<h1>[목록]</h1>
	<table border = 1  >
		<tr>
			<td width = 100>성명</td>
			<td width = 100>포인트</td>
			<td width = 100>보낸메시지</td>
			<td width = 100>받은메시지</td>
		</tr>
		<c:forEach items = "${list }" var = "vo">
			<tr>
				<td width=100>${vo.uid }</td>
				<td width=100>${vo.upw }</td>
				<td width=100>${vo.uname }</td>
				<td width=100>${vo.point }</td>
				<td width=100><button onClick="location.href='send?uid=${vo.uid}' ">보낸메시지</button>
				<td width=100><button onClick="location.href='receive?uid=${vo.uid}' ">받은메시지</button>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
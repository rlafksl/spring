<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소등록</title>
</head>
<body>
	<h1>[주소등록]</h1>
	<form action="insert" method="post">
	<table border=1>
		<tr>
			<td width=100>이름:</td>
			<td width=500><input type="text" name="name"></td>
		</tr>
		<tr>
			<td width=100>전화:</td>
			<td width=500><input type="text" name="tel"></td>
	</tr>
		<tr>
			<td width=100>주소:</td>
			<td width=500><input type="text" name="addr"></td>
	</tr>
	</table>
	<input type="submit" value="저장">
	<input type="reset" value="취소">
	<input type="button" value="목록" onClick="location.href='list' ">
	</form>
</body>
</html>
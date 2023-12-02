<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="add" method="post">
	<table align=center border=1 width=600>
		<tr align=center>
			<td>帳號:
			<td><input type="text" name="username">
		<tr align=center>
			<td>密碼:
			<td><input type="password" name="password">
		<tr align=center>
			<td>姓名:
			<td><input type="text" name="name">
		<tr align=center>
			<td>電話:
			<td><input type="text" name="phone">
		<tr align=center>
			<td colspan=2><input type="submit" value="ok">
	</table>
</form>
</body>
</html>
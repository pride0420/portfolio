<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.member"%>
<!DOCTYPE html>
<%
member m=(member)session.getAttribute("M");


%>
<html>
<head>
<link rel="stylesheet" href="css/loginSuccess.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align="right" border=0 width=150>
	<tr align="left">
		<td><b>歡迎!</b><%=m.getName() %>
	<tr>
		<td>
			<div class="dropdown">
  <button class="dropbtn">選單</button>
  <div class="dropdown-content">
    <a href="queryName">我的文章</a>
    <a href="querylike">我的最愛</a>
    <a href="#">商城</a>
    <a href="goGame">小遊戲</a>
    <a href="setting">設定</a>
    <a href="loginout">登出</a>
  </div>
</div>
	<tr>
		<td><br><br><br><br><br><br><br><br><br><br><br><br>
</table>
<h1 align="center">飛鳥商城</h1>
</body>
</html>
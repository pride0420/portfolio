<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
   import="com.example.demo.vo.member
    ,java.util.List,com.example.demo.vo.chat"%>
<!DOCTYPE html>
<%
member m=(member)session.getAttribute("M");
chat c=(chat)session.getAttribute("subject");
int id=Integer.parseInt(request.getParameter("id"));
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
    <a href="queryName?name="<%=m.getName() %>>我的文章</a>
    <a href="#">我的最愛</a>
    <a href="#">商城</a>
    <a href="setting">設定</a>
    <a href="loginout">登出</a>
  </div>
</div>
	<tr>
		<td><br><br><br><br><br><br><br><br><br><br><br><br>
</table>
<form action="update" method="post">
	<op><table align=center border=1 width=600>
		<tr align=center>
			<td>標題:
			<td><input type="text" name="subject">
		<tr align=center>
			<td colspan=2><textarea rows="5" cols="70" name="content" placeholder="請輸入內容"></textarea>
		<tr align=center>
			<td colspan=2>
			<input type="submit" value="送出">
			<input type="reset" value="清除">
			<input type ="button" onclick="history.back()" value="回到上一頁">
			<input type="hidden" name="id" value=<%=id %>>
	</table></op>
</form>
</body>
</html>
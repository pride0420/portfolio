<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import="com.example.demo.vo.Member,java.util.List,com.example.demo.vo.Chat"%>
<%
Member m=(Member)session.getAttribute("M");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/loginSuccess.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align="right" border=0 width=150>
	<tr align="left">
		<td><font size=4><b>歡迎!</b></font><font size=5><%=m.getName() %></font>
	<tr>
		<td>
<div class="dropdown">
  <button class="dropbtn">選單</button>
  <div class="dropdown-content">
    <a href="queryName">我的文章</a>
    <a href="querylike">我的最愛</a>
    <a href="goshop?items=手機">商城</a>
    <a href="goGame">小遊戲</a>
    <a href="setting">設定</a>
    <a href="loginout">登出</a>
  </div>
</div>
	<tr><td><br><br><br><br><br><br><br><br><br><br><br><br><br>
</table>
<table align=center>
	<tr align=center>
	<td><div id="header" >飛鳥社群</div>
</table>

<form action="updatename" method="post">
	<op><table align="center" border=1 width=600  cellpadding="5" cellspacing="2">
		<tr align=center>
			<td colspan=2>修改資料
		<tr align=center>
			<td>姓名:
			<td><input type="text" name="name" value="" placeholder=<%=m.getName() %>>
		<tr align=center>
			<td>手機:
			<td><input type="text" name="phone" value="" placeholder=<%=m.getPhone() %>>
		<tr align="center">
			<td colspan=2>
			<input type="submit" value="送出"> | 
			<input type="reset" value="清除"> | 
			<input type ="button" onclick="history.back()" value="回到上一頁">
			
	
	
	
	</table>
<op>
</form>
</body>
</html>
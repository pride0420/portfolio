<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.Member,java.util.List,com.example.demo.vo.GamePlayer"%>
<!DOCTYPE html>
<%
Member m=(Member)session.getAttribute("M");
List<GamePlayer> l=(List<GamePlayer>)session.getAttribute("PLAYALL");
%>
<html>
<link rel="stylesheet" href="css/loginSuccess.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align="right" border=0 width=150>
	<tr align="left">
		<td><font size=4><b>歡迎!</b></font><font size=5><%=m.getName()%></font>
	<tr>
		<td>
			<div class="dropdown">
  <button class="dropbtn">選單</button>
  <div class="dropdown-content">
    <a href="queryName">我的文章</a>
    <a href="querylike">我的最愛</a>
    <a href="goshop">商城</a>
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
<form action="addplayer" method="get">
	<op><table width=610 align=center border=1 cellpadding="5" cellspacing="2">
		<tr align=center>
			<td colspan=2><h2>輸入四個數字(1~9 不重複)</h2>
		<tr align=center>
			<td  width=40%>第一個
			<td width=60%><input type="text" name="playernub" maxlength=4 minlength=0 size=10 
			oninput="value=value.replace(/[^\d]/g,'')">
			
		<tr align=center>
			<td colspan=2><input type="submit" value="確定">

	</table></op></form>
	<op><table width=610 align=center border=1 cellpadding="5" cellspacing="2">
	<%
	if(l!=null){
		out.println("<tr align=center><td>次數<td>猜的數<td>共猜對<td>剩餘次數");
			for(GamePlayer o:l){
		int x=20-o.getReno();
		out.println("<tr align=center><td>第"+o.getReno()+
		"次<td>"+o.getPlayernub()
		+"<td>"+o.getA()+"A"+o.getB()+"B"
		+"<td>"+x);
		
			}
			}
	%>
	
	
	
	
	
	</table></op>
	
	
	

</body>
</html>
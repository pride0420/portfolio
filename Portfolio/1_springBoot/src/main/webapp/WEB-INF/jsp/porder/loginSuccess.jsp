<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.member
    ,java.util.List,com.example.demo.vo.chat"%>
<!DOCTYPE html>
<%
member m=(member)session.getAttribute("M");
List<chat> c=(List<chat>)session.getAttribute("All");

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
		<td><font size=4><b>歡迎!</b></font><font size=5><%=m.getName() %></font>
	<tr>
		<td>
			<div class="dropdown">
  <button class="dropbtn">選單</button>
  <div class="dropdown-content">
    <a href="queryName">我的文章</a>
    <a href="querylike">我的最愛</a>
    <a href="gophone?items=手機">商城</a>
    <a href="goGame">小遊戲</a>
    <a href="setting">設定</a>
    <a href="loginout">登出</a>
  </div>
</div>
	
</table>
<div id="header">飛鳥社群</div>
<form action="addchat" method="post">
	<op><table align=center border=1 width=600 cellpadding="5" cellspacing="2">
		<tr align=center>
			<td>標題:
			<td><input type="text" name="subject" size="30" >
		<tr align=center>
			<td colspan=2><textarea rows="5" cols="70" name="content" placeholder="請輸入內容"></textarea>
		<tr align=center>
			<td colspan=2>
			<input type="submit" value="送出"> | 
			<input type="reset" value="清除">  
			<input type="hidden" name="chatNo" value=<%=m.getMemberNo() %>>
	</table></op>
</form>
<op><table align=center border=1 width=600 cellpadding="5" cellspacing="2">
	<%
		for(chat o:c){
			if(o.getLike()==null||o.getLike()==""){
				o.setLike("收藏");
			}
			out.println("<tr align=center><td>留言者: "+o.getName()+"<td>標題: "+o.getSubject()
			+"<tr align=center><td colspan=2 height=100>"+o.getContent()+
			"<tr><td colspan=2 align=right >"+"<table align=left><tr><td>留言時間: "+o.getFirsttime().toLocaleString()+"</table>"+
			"<a href=addlike?id="+o.getId()+">"
			+o.getLike()+"</a><tr><td colspan=2 style=background-color:#F7A578><br>");
			
		}
	
	
	%>


</table></op>

</body>
</html>
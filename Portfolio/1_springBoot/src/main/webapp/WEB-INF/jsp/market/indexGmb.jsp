<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="com.example.demo.vo.Member,com.example.demo.vo.Porder,java.util.List"%>
<!DOCTYPE html>
<%
Member m=(Member)session.getAttribute("M");
List<Porder> l=(List<Porder>)session.getAttribute("Porder");
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
		<td><font size=4><b>歡迎!</b></font><font size=5><%=m.getName()%></font>
	<tr>
		<td>
			<div class="dropdown">
  <button class="dropbtn">選單</button>
  <div class="dropdown-content">
    <a href="index">留言板</a>
    <a href="queryshopcar">購物車</a>
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
<op><table width=600 border=1 align=center cellpadding="5" cellspacing="2">
	<tr align=center>
		<td colspan=2 style=background-color:#7AB6CD>第 <a href="goshop?items=手機">1 | </a><a href="goshop?items=電腦">2</a> | 3 | <a href="goshop?items=其他">4</a> 頁
		
	
		
	
		<%
		for(Porder o:l){
				out.println("<tr align=center><td height=250><img height=200 width=175 src=img/"+o.getImgNo()+".jpg"
				+"><td width=70% >商品名稱: "+o.getProduct()+"<br>規格: "+o.getMode()+"<br>價格: "+o.getAmount()
				+"<tr align=right><td colspan=2 style=background-color:#F7A578><a href=addshop?items=電動&porderNo="+o.getPorderNo()+"&memberNo="+m.getMemberNo()+">加入購物車</a>"
				+" | 已加入: "+o.getToto());
			}
		%>


</table></op>
</body>
</html>
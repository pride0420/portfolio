<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.example.demo.vo.member
    ,com.example.demo.vo.shopcart
    ,java.util.List"%>
<!DOCTYPE html>
<%
member m = (member) session.getAttribute("M");
List<shopcart> l = (List<shopcart>) session.getAttribute("Spcar");
String xx = "";
int Total=0;

for(shopcart s:l){
	Total=Total+s.getShop_sum();
}


%>
<html>
<link rel="stylesheet" href="css/loginSuccess.css">
<link rel="stylesheet" href="css/shop.css">
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
						<a href="index">留言板</a> <a href="queryshopcart">購物車</a> <a
							href="gophone?items=手機">商城</a> <a href="goGame">小遊戲</a> <a href="setting">設定</a>
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
			<td colspan=2 style=background-color:#7AB6CD><a href="gophone?items=手機"><input type ="button" value="回商城"></a> | 
				購物車總金額: <font color=red><b><%=Total %></b></font>
				<%
				for (shopcart o : l) {
					out.println("<tr align=center><td height=250 width=300><img height=200 width=175 src=img/" + o.getImgNo() + ".jpg"
					+ "><td>商品名稱: " + o.getProduct() +"<br>規格: "+o.getMode() +"<br>商品價格: " + o.getShop_amount() + "<br>選購數量: " + o.getShop_num()
					+ "<br>總金額: " + o.getShop_sum() + "<tr align=right><td colspan=2 style=background-color:#F7A578><l><a href=updateNum?xx=增加&id=" + o.getId()
					+ ">在加一個</a>" + " | <a href=updateNum?xx=減少&id=" + o.getId() + ">減少一個</a>"
					+ " | <a href=updateNum?xx=刪除&id=" + o.getId() + ">不要這個</a></l>");
				}
				%>
			
	</table>

	</op>
</body>
</html>
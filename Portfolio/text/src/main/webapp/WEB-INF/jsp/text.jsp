<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.text,java.util.List"%>
<!DOCTYPE html>
<%
List<text> t=(List<text>)session.getAttribute("T");
//String T=session.getAttribute("TEXT").toString();
String[] L=(String[])session.getAttribute("Last");

%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width=600 align=center border=1>
<%
	for(int i=0;i<L.length;i++){
		out.println("<tr align=center><td>"+L[i]);
	}
	


%>


</table>
</body>
</html>
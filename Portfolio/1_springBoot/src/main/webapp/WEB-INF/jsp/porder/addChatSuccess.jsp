<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
String ul=session.getAttribute("UL").toString();

switch(ul){
	case "chat":
		String content=0.1+";URL="+"index";
		response.setHeader("REFRESH",content);
	break;
	case "dlechat":
		content=0.1+";URL="+"querylike";
		response.setHeader("REFRESH",content);
	break;
	case "手機":
		content=0.1+";URL="+"phone";
		response.setHeader("REFRESH",content);
	break;
	case "電腦":
		content=0.1+";URL="+"cpu";
		response.setHeader("REFRESH",content);
	break;
	case "電動":
		content=0.1+";URL="+"gmb";
		response.setHeader("REFRESH",content);
	break;
	case "其他":
		content=0.1+";URL="+"other";
		response.setHeader("REFRESH",content);
	break;
	case "upnum":
		content=0.1+";URL="+"queryshopcart";
		response.setHeader("REFRESH",content);
	break;
	case "gameplay":
		content=0.1+";URL="+"gotoplay";
		response.setHeader("REFRESH",content);
	break;
	
}

%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
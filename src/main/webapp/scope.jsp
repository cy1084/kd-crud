<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>scope</h2>
	<%
	Map<String, String> map = new HashMap<>();
	map.put("name", "홍길동");
	map.put("age", "22");
	map.put("address", "seoul");
	request.setAttribute("user",map);
	session.setAttribute("user1", map);
	%>
	
	<%=map %><!--오류 안남/ 변수명으로 출력 -->
	${map } <!--오류/ 4가지 scope의 키 값을 써야됨!! -->
	${user }
	${user.name }

</body>
</html>
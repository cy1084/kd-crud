<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/user-info/login" method="POST">
	<!-- doPost 호출 -->
		<input type="text" name="uiId" placeholder="ID"><br> <input
			type="password" name="uiPwd" placeholder="Password"><br>
		<button>로그인</button>

	</form>

</body>
</html>
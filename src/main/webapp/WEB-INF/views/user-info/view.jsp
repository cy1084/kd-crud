<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>유저 상세화면</h3>
${userInfo }
이름: ${userInfo.uiName}<br>
생년월일: ${userInfo.uiBirth }<br>
소개: ${userInfo.uiDesc }<br>
가입일: ${userInfo.credat }<br>
<button type="button" onclick="location.href='/user-info/update?uiNum=${userInfo.uiNum}'">수정</button>
<button>삭제</button>
</body>
</html>
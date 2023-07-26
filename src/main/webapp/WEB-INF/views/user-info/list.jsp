<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>유저 리스트</h3>
	<!-- ${userInfoList }-->
	<!-- el 태그 -->
	<c:forEach items="${userInfoList}" var="userInfo">
		${userInfo.uiNum },${userInfo.uiName },
		<a href="/user-info/view?uiNum=${userInfo.uiNum }">${userInfo.uiId }</a>
		<br>
		<!-- WEB-INF에 있는 jsp는 바로 접근 못하기 때문에 servlet을 거쳐야 함!  -->

	</c:forEach>
	<a href="/user-info/insert">등록</a>

</body>
</html>
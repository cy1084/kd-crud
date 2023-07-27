<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>

</head>
<body>
	<h3>게시물 리스트</h3>

	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ biList}" var="board">
					<tr>
						<td>${board.biNum }</td>
						<td><a href="/board-info/view?biNum=${board.biNum }">${board.biTitle }</a></td>
						<td>${board.uiNum }</td>
						<td>${board.credat }</td>
					</tr>
				</c:forEach>

				<tr>
					<td colspan="4" align="right"><button type="button"
							class="btn btn-primary" onclick="goPage('/board-info/insert')">게시물 등록</button>
				</tr>

			</tbody>
		</table>
	</div>
	<script>
		function goPage(url) {
			location.href=url;
		}
		//alert(1);
		//function (클래스의 메소드)
	</script>

</body>
</html>
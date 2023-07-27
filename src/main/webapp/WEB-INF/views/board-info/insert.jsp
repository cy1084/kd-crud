<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
	<h3>게시물 등록</h3>
	<div class="container">
		<form method="POST" action="/board-info/insert">
			<div class="form-group">
				<label for="biTitle">제목</label> <input type="text"
					class="form-control" id="biTitle" name="biTitle"
					placeholder="제목을 입력해주세요.">
				<!-- name 값으로 백앤드에서 request.get~ 해야 함 -->
			</div>
			<div class="form-group">
				<label for="biContent">내용</label>
				<textarea class="form-control" id="biContent" name="biContent"
					placeholder="내용을 입력해주세요."></textarea>
			</div>
			
			<button type="submit" class="btn btn-primary">게시물 등록</button>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.msg{
 color: red;
}
</style>
</head>
<body>

	<a href="board/list">게시판</a>
	<a href="member/join">회원가입</a>
	<a href="member/login">로그인</a>
	<a href="member/logout">로그아웃</a>
	<form>
	<p class ="msg">${msg}</p>
	</form>
	<h1>저희 홈페이지에 오실걸 환영합니다.</h1>

</body>
</html>
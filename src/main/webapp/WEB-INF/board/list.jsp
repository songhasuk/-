<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="write">글쓰기</a>
	<hr>
	<table>
		<tr>
			<td>NO</td>
			<td>제목</td>
			<td>조회수</td>
			<td>작성자</td>
			<td>작성일</td>
		</tr>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.no }</td>
			<td>${dto.subject }</td>
			<td>${dto.readCount }</td>
			<td>${dto.writer }</td>
			<td>${dto.createdDate }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
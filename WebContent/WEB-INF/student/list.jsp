<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>학생목록</title>
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>학 생 목 록 페 이 지</h2>
		<hr color="green" width="300">
		<table border="1" width="500">
			<tr bgcolor="yellow">
				<th width="100">아이디</th>
				<th width="150">학생명</th>
				<th width="250">학급명</th>
			</tr>
			<c:if test="${empty list }">
				<tr>
					<td colspan="3">등록된 학생이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach var="dto" items="${list}">
				<tr>
					<td align="center">${dto.id}</td>
					<td align="center">${dto.name}</td>
					<td align="center">${dto.cname}</td>
				</tr>			
			</c:forEach>		
		</table>
	</div>
</body>
</html>







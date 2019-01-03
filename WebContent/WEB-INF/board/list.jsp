
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="../style.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div align="center">
<table border="1">
<tr><caption><h2>글목록</h2></caption></tr>
<tr><td colspan="6" align="right"><a href="writeForm.brd">글쓰기</a></td></tr>
<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회</th><th>ip</th></tr>
<c:choose>
	<c:when test="${empty list}">
	<tr><td colspan="6"><h1>작성된 글이 없습니다.</h1></td></tr>
	</c:when>
	<c:otherwise>
	<c:forEach var="dto" items="${list}">
	<tr><th>${dto.num}</th><th><a href="context.brd?num=${dto.num}&readcount=${dto.readcount}&filename=${dto.filename}">${dto.subject}</a></th><th>${dto.writer}</th><th>${dto.reg_date}</th><th>${dto.readcount}</th><th>${dto.ip}</th></tr>
	</c:forEach>	
	</c:otherwise>
</c:choose>



</table>
</div>
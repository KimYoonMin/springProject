<%@page import="board.BoardDBBean"%>
<%@page import="board.BoardDataBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="boardDAO" class="board.BoardDataBean"/>
<jsp:useBean id="boardDTO" class="board.BoardDBBean"/>

<link rel="stylesheet" type="text/css" href="../style.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%	
	int num = Integer.parseInt(request.getParameter("num"));
	String filename = request.getParameter("filename");
%>
<div align="center">
<h3>글삭제</h3>
<form action="deletePro.jsp" method="post">
<table border="1">
<tr><td>비밀번호를 입력해주세요</td></tr>
<tr><td>비밀번호 : <input type="text" name="passwd"></td></tr>
<tr><td><input type="submit" value="글삭제"><input type="button" value="글목록" onclick="location.href='list.jsp'"></td></tr>
<input type="hidden" name="num" value="<%=num %>">
<input type="hidden" name="filename" value="<%=filename %>">
</table>
</form>
</div>

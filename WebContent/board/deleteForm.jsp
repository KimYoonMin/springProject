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
<h3>�ۻ���</h3>
<form action="deletePro.jsp" method="post">
<table border="1">
<tr><td>��й�ȣ�� �Է����ּ���</td></tr>
<tr><td>��й�ȣ : <input type="text" name="passwd"></td></tr>
<tr><td><input type="submit" value="�ۻ���"><input type="button" value="�۸��" onclick="location.href='list.jsp'"></td></tr>
<input type="hidden" name="num" value="<%=num %>">
<input type="hidden" name="filename" value="<%=filename %>">
</table>
</form>
</div>

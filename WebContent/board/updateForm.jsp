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
	BoardDBBean dto = boardDAO.listBoard_View(num); 
%>
<div align="center"><h3>�ۼ���</h3>
<form action="updatePro.jsp" method="post">
<table border="1">
<tr><td>�̸�</td><td><input type="text" name="writer" value="<%=dto.getWriter()%>"></td></tr>
<tr><td>����</td><td><input type="text" name="subject" value="<%=dto.getSubject()%>"></td></tr>
<tr><td>�̸���</td><td><input type="text" name="emial" value="<%=dto.getEmail()%>"></td></tr>
<tr><td>����</td><td><textarea name="content" rows="10" cols="50"><%=dto.getContent()%></textarea></td></tr>
<tr><td>��й�ȣ</td><td><input type="text" name="passwd"></td></tr>
<tr><td colspan="3"><input type="submit" value="�۾���"><input type="reset" value="�ٽ��ۼ�"><input type="button" value="��Ϻ���" onclick="location='list.jsp'"></td></tr>
<input type="hidden" name="num" value="<%=num%>">
</table>
</form>
</div>
<%@page import="board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="boardDAO" class="board.BoardDataBean"/>
<jsp:useBean id="boardDTO" class="board.BoardDBBean"/>
<link rel="stylesheet" type="text/css" href="../style.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	BoardDBBean[] dto = boardDAO.listBoard();	
%>
<div align="center">
<table border="1">
<tr><caption><h2>�۸��</h2></caption></tr>
<tr><td colspan="6" align="right"><a href="writeForm.jsp">�۾���</a></td></tr>
<tr><th>��ȣ</th><th>����</th><th>�ۼ���</th><th>�ۼ���</th><th>��ȸ</th><th>ip</th></tr>
<%if(dto.length<0){  %>
<tr><td colspan="6"><h1>�ۼ��� ���� �����ϴ�.</h1></td></tr>
<%}else{ 
	for(int i=0 ; i<dto.length ; ++i){
	System.out.println(dto[i].getFilename());
	%>
	
<tr><th><%=dto[i].getNum()%></th><th><a href="context.jsp?num=<%=dto[i].getNum()%>&readcount=<%=dto[i].getReadcount()%>&filename=<%=dto[i].getFilename()%>"><%=dto[i].getSubject()%></a></th><th><%=dto[i].getWriter()%></th><th><%=dto[i].getReg_date()%></th><th><%=dto[i].getReadcount()%></th><th><%=dto[i].getIp()%></th></tr>
<%}} %>


</table>
</div>
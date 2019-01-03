<%@page import="board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%request.setCharacterEncoding("EUC-KR"); %>
    <jsp:useBean id="boardDAO" class="board.BoardDataBean"/>

<link rel="stylesheet" type="text/css" href="../style.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	int num = Integer.parseInt(request.getParameter("num"));	
	int readcount = Integer.parseInt(request.getParameter("readcount"));
	String filename = request.getParameter("filename");
	int res = boardDAO.updatetBoard_readcount(num, readcount);
	BoardDBBean dto = boardDAO.listBoard_View(num);
	String upPath = config.getServletContext().getRealPath("/board/images");	
%>
<div align="center">
<h1>글내용 보기</h1>
<table border="1">
<tr><td>글번호</td><td><%=dto.getNum() %></td><td>조회수</td><td><%=dto.getReadcount() %></td></tr>
<tr><td>작성자</td><td><%=dto.getWriter() %></td><td>작성일</td><td><%=dto.getReg_date() %></td></tr>
<tr><td>글제목</td><td colspan="3"><%=dto.getSubject() %></td></tr>
<tr><td>글내용</td><td colspan="3"><%=dto.getContent() %></td></tr>
<tr><td>이미지</td><td colspan="3"><img src="<%=upPath%>/<%=filename%>" width="100" height="100"></td></tr>
<tr><td colspan="4" align="right"><input type="button" value="답글달기" onclick="location.href='writeForm.jsp?num=<%=dto.getNum()%>'"><input type="button" value="글수정" onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'"><input type="button" value="글삭제" onclick="location.href='deleteForm.jsp?num=<%=dto.getNum()%>&filename=<%=dto.getFilename()%>'"><input type="button" value="글목록" onclick="location.href='list.jsp'"></td></tr>
</table>
</div>

<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="boardDAO" class="board.BoardDataBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%	
	MultipartRequest mr = null;
	String upPath = config.getServletContext().getRealPath("/board/images");	
	System.out.println("upPath: "+upPath);
	int len = 10*1024*1024;
	try{
		mr = new MultipartRequest(request, upPath, len, "EUC-KR");
	}catch(IOException e){%>
		<script type="text/javascript">
			alert("파일 전송 실패!! 관리자에게 문의하세요");
			location.href="list.jsp";
		</script>
	<%	e.printStackTrace();return;	
	}
	int res = boardDAO.insertBoard(mr);
	/* boardDTO.getWriter(), boardDTO.getEmail(), boardDTO.getPasswd(), boardDTO.getSubject(),
	boardDTO.getContent(), boardDTO.getIp() */
	if(res>0){%>
		<script type="text/javascript">
			alert("글쓰기 성공!")
			location.href="list.jsp"
		</script>		
	<%}else{%>
		<script type="text/javascript">
			alert("글쓰기 실패!")
			history.back()
		</script>
	<%}
%>
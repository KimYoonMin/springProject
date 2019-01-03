<%@page import="board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="boardDAO" class="board.BoardDataBean"/>
<jsp:useBean id="boardDTO" class="board.BoardDBBean"/>
<jsp:setProperty property="*" name="boardDTO"/>>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%	
	BoardDBBean dto = boardDAO.listBoard_View(boardDTO.getNum());
	if(boardDTO.getPasswd().equals(dto.getPasswd())){
	int res = boardDAO.updatetBoard(boardDTO.getNum(), boardDTO.getWriter(), boardDTO.getSubject(), boardDTO.getEmail(), boardDTO.getContent());
	if(res>0){%>
		<script type="text/javascript">
			alert("글수정 성공!")
			location.href="list.jsp"
		</script>		
	<%}else{%>
		<script type="text/javascript">
			alert("글수정 실패!")
			history.back()
		</script>
	<%}}else{%>
		<script type="text/javascript">
			alert("비밀번호가 틀렸습니다.!")
			history.back()
		</script>
	<%}
%>
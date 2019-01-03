<%@page import="java.io.File"%>
<%@page import="board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="boardDAO" class="board.BoardDataBean"/>
<jsp:useBean id="boardDTO" class="board.BoardDBBean"/>
<jsp:useBean id="dbPool" class="board.ConnectionPoolBean" scope="application"/>
<jsp:setProperty property="*" name="boardDTO"/>
<jsp:setProperty property="pool" name="boardDAO" value="<%=dbPool%>"/>
<link rel="stylesheet" type="text/css" href="../style.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%	
	BoardDBBean dto = boardDAO.listBoard_View(boardDTO.getNum());	
	if(dto.getPasswd().equals(boardDTO.getPasswd())){
	String upPath = config.getServletContext().getRealPath("/board/images");
	File file = new File(upPath+"/"+dto.getFilename());     
    if( file.exists() ){
        if(file.delete()){
            System.out.println("���ϻ��� ����");
        }else{
            System.out.println("���ϻ��� ����");
        }
    }else{
        System.out.println("������ �������� �ʽ��ϴ�.");
    }
		
	int res = boardDAO.deleteBoard(boardDTO.getNum());
	
	if(res>0){%>
		<script type="text/javascript">
		alert("��������!")
		location.href="list.jsp"
		</script>
	<%}else{%>
		<script type="text/javascript">
			alert("���� ����!")
			history.back()
		</script>
	<%}
	}else{%>
	<script type="text/javascript">
			alert("��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.!")
			history.back()
		</script>	
	<%}
%>
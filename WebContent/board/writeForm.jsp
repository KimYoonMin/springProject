<%@page import="java.net.Inet4Address"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%request.setCharacterEncoding("EUC-KR"); %>
    <jsp:useBean id="boardDAO" class="board.BoardDataBean"/>
<jsp:useBean id="boardDTO" class="board.BoardDBBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%	
	String ip=Inet4Address.getLocalHost().getHostAddress();
%>
<div align="center">
<form action="writePro.jsp" method="post" enctype="multipart/form-data">
<table border="1">
<tr><th colspan="2" align="center">�۾���</th></tr>
<tr><td>�̸�</td><td><input type="text" name="writer"></td></tr>
<tr><td>����</td><td><input type="text" name="subject"></td></tr>
<tr><td>�̸���</td><td><input type="text" name="emial"></td></tr>
<tr><td>����</td><td><textarea id="content" name="content" rows="10" cols="50"></textarea></td></tr>
<tr><td>����÷��</td><td><input type="file" name="filename"></td></tr>
<tr><td>��й�ȣ</td><td><input type="text" name="passwd"></td></tr>
<tr><td colspan="3"><input type="submit" value="�۾���"><input type="reset" value="�ٽ��ۼ�"><input type="button" value="��Ϻ���" onclick="location='list.jsp'"></td></tr>
<input type="hidden" name="ip" value="<%=ip%>">
</table>
</form>
</div>
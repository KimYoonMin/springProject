<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="../style.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div align="center"><h3>�ۼ���</h3>
<form action="updatePro.brd" method="post">
<table border="1">
<tr><td>�̸�</td><td><input type="text" name="writer" value="${dto.writer}"></td></tr>
<tr><td>����</td><td><input type="text" name="subject" value="${dto.subject}"></td></tr>
<tr><td>�̸���</td><td><input type="text" name="email" value="${dto.email}"></td></tr>
<tr><td>����</td><td><textarea name="content" rows="10" cols="50">${dto.content}</textarea></td></tr>
<tr><td>��й�ȣ</td><td><input type="text" name="passwd"></td></tr>
<tr><td colspan="3"><input type="submit" value="�۾���"><input type="reset" value="�ٽ��ۼ�"><input type="button" value="��Ϻ���" onclick="location='list.brd'"></td></tr>
<input type="hidden" name="num" value="${dto.num}">
</table>
</form>
</div>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="../style.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div align="center">
<h1>�۳��� ����</h1>
<table border="1">
<tr><td>�۹�ȣ</td><td>${dto.num}</td><td>��ȸ��</td><td>${dto.readcount}</td></tr>
<tr><td>�ۼ���</td><td>${dto.writer}</td><td>�ۼ���</td><td>${dto.reg_date}</td></tr>
<tr><td>������</td><td colspan="3">${dto.subject}</td></tr>
<tr><td>�۳���</td><td colspan="3">${dto.content}</td></tr>
<tr><td>�̹���</td><td colspan="3"><img src="${upPath}/${filename}" width="100" height="100"></td></tr>
<tr><td colspan="4" align="right"><input type="button" value="��۴ޱ�" onclick="location.href='writeForm.brd?num=${dto.num}&re_step=${dto.re_step}&re_level=${dto.re_level}'"><input type="button" value="�ۼ���" onclick="location.href='updateForm.brd?num=${dto.num}'"><input type="button" value="�ۻ���" onclick="location.href='deleteForm.brd?num=${dto.num}&filename=${dto.filename}'"><input type="button" value="�۸��" onclick="location.href='list.brd'"></td></tr>
</table>
</div>

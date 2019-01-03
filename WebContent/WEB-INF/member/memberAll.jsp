<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%-- <jsp:useBean id="memberdto" class="my.member.MemberDTO"/> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="../style.css">
<script type="text/javascript">
	function editMember(){
		window.open("member_edit.mem", "ȸ����������", "width=640, height=400")
					/*    ��ġ/                �̸�/                   ũ�� */
	}
</script>
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<hr color="green" width="300">
		<c:choose>
		<c:when test="${!(empty mode)}">		
			<h2>ȸ �� �� �� �� ��</h2>
			</c:when>
			<c:otherwise>
			<h2>ȸ �� ã ��</h2>
			<form name="f" method="post">
			<select name="search">
			<option value="id">���̵�</option>
			<option value="name">ȸ����</option>
			</select>
			<input type="text" name="searchString">
			<input type="submit" value="ã��">
			</form>
			</c:otherwise>
			</c:choose>
		<hr color="green" width="300">
		<table border="0" class="outline">
		<tr class="outline">
		<th>��ȣ</th>
		<th>�̸�</th>
		<th>���̵�</th>
		<th>�̸���</th>
		<th>��ȭ��ȣ</th>
		<th>������</th>
		<th>����|����</th>
		</tr>
<c:forEach var="dto" items="${list}">
		<tr>
		<th>${dto.no}</th>
		<th>${dto.name}</th>
		<th>${dto.id}</th>
		<th>${dto.email}</th>
		<th>${dto.hp1}-${dto.hp2}-${dto.hp3}</th>
		<th>${dto.joindate}</th>
		<th><a href="member_edit.mem?no=${dto.no}&name=${dto.name}
		&id=${dto.id}&email=${dto.email}&hp1=${dto.hp1}
		&hp2=${dto.hp2}&hp3=${dto.hp3}&joindate=${dto.joindate}">����</a>|<a href="member_delete.mem?no=${dto.no}">����</a></th>
		</tr>
</c:forEach>
		</table>
</body>
</html>
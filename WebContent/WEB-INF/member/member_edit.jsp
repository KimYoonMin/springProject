<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="../style.css">
<title>회원정보 수정</title>
</head>
<body>
<div align="center">
		<hr color="green" width="300">
			<h2>회 원 정 보 수 정</h2>
		<hr color="green" width="300">
		<form name="f" action="member_edit_function.mem" method="post">
		
		<table border="0" class="outline">
		<tr class="outline">
		<th>번호</th>
		<th>이름</th>
		<th>아이디</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>가입일</th>		
		</tr>
	
		<tr>
		<td><input type="text" name="no" class="box" size="3" value="${dto.no}" readonly="readonly"></td>
		<td><input type="text" name="name" class="box" size="4" value="${dto.name}" readonly="readonly"></td>
		<td><input type="text" name="id" class="box" value="${dto.id}" readonly="readonly"></td>		
		<td><input type="text" name="email" class="box" value="${dto.email}"></td>
		<td><input type="text" name="hp1" class="box" size="3" maxlength="3" value="${dto.hp1}"> -
			<input type="text" name="hp2" class="box" size="4" maxlength="4" value="${dto.hp2}"> -
			<input type="text" name="hp3" class="box" size="4" maxlength="4" value="${dto.hp3}">
		</td>
		<td><input type="text" name="joindate" class="box" maxlength="4" value="${dto.joindate}" readonly="readonly"></td>		
		</tr>
		<tr>					
			<td colspan="2" align="center">
			<input type="submit" value="수정하기">
			<input type="reset" value="처음으로">
			</td>
		</tr>
		</table>
		
		</form>
		</div>
</body>
</html>
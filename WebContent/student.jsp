<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <!-- student.jsp -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>학생관리</title>
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>학 생 등 록 페 이 지</h2>
		<hr color="green" width="300">
		<form name="f" action="insert.do" method="post">
			<table border="1">
				<tr>
					<td>
					 아이디 : <input type="text" name="id"><br>
					 학생명 : <input type="text" name="name"><br>
					 학급명 : <input type="text" name="cname"><br>
					 <input type="submit" value="등록">
					 <input type="reset" value="취소">
					</td>
				</tr>
			</table>
		</form>
		<!-- --------------------------------------------------------------- -->
		<hr color="green" width="300">
		<h2>학 생 삭 제 페 이 지</h2>
		<hr color="green" width="300">
		<form name="f" action="delete.do" method="post">
			<table border="1">
				<tr>
					<td>
					 아이디 : <input type="text" name="id"><br>					
					 <input type="submit" value="삭제">					 
					</td>
				</tr>
			</table>
		</form>
		<!-- --------------------------------------------------------------- -->
		<hr color="green" width="300">
		<h2>학 생 찾 기 페 이 지</h2>
		<hr color="green" width="300">
		<form name="f" action="find.do" method="post">
			<table border="1">
				<tr>
					<td>
					 이름 : <input type="text" name="name"><br>					
					 <input type="submit" value="찾기">					 
					</td>
				</tr>
			</table>
		</form>
		<!-- --------------------------------------------------------------- -->
		<hr color="green" width="300">
		<h2>학 생 목 록 페 이 지</h2>
		<hr color="green" width="300">
		<form name="f" action="list.do" method="post">
			<table border="1">
				<tr>
					<td>					 			
					 <input type="submit" value="학생목록페이지">					 
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
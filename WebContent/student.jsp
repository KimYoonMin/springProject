<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <!-- student.jsp -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�л�����</title>
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>�� �� �� �� �� �� ��</h2>
		<hr color="green" width="300">
		<form name="f" action="insert.do" method="post">
			<table border="1">
				<tr>
					<td>
					 ���̵� : <input type="text" name="id"><br>
					 �л��� : <input type="text" name="name"><br>
					 �б޸� : <input type="text" name="cname"><br>
					 <input type="submit" value="���">
					 <input type="reset" value="���">
					</td>
				</tr>
			</table>
		</form>
		<!-- --------------------------------------------------------------- -->
		<hr color="green" width="300">
		<h2>�� �� �� �� �� �� ��</h2>
		<hr color="green" width="300">
		<form name="f" action="delete.do" method="post">
			<table border="1">
				<tr>
					<td>
					 ���̵� : <input type="text" name="id"><br>					
					 <input type="submit" value="����">					 
					</td>
				</tr>
			</table>
		</form>
		<!-- --------------------------------------------------------------- -->
		<hr color="green" width="300">
		<h2>�� �� ã �� �� �� ��</h2>
		<hr color="green" width="300">
		<form name="f" action="find.do" method="post">
			<table border="1">
				<tr>
					<td>
					 �̸� : <input type="text" name="name"><br>					
					 <input type="submit" value="ã��">					 
					</td>
				</tr>
			</table>
		</form>
		<!-- --------------------------------------------------------------- -->
		<hr color="green" width="300">
		<h2>�� �� �� �� �� �� ��</h2>
		<hr color="green" width="300">
		<form name="f" action="list.do" method="post">
			<table border="1">
				<tr>
					<td>					 			
					 <input type="submit" value="�л����������">					 
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
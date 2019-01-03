<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입유무</title>
<link rel="stylesheet" type="text/css" href="../style.css">
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
			<h2>회 원 가 입 유 무</h2>
		<hr color="green" width="300">
		
		<form name="f" action="checkMember_example.mem" method="post">
			<table border="0" class="outline">
				<tr>
					<th>회원명</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>주민번호</th>
					<td>
						<input type="text" name="ssn1" class="box" maxlength="6">
						-<input type="password" name="ssn2" class="box" maxlength="7">
					</td>
				</tr>
				<tr>					
					<td colspan="2" align="center">
						<input type="submit" value="다음으로">
						<input type="reset" value="처음으로">
					</td>
				</tr>
			</table>	
		</form>
	
	
	
	</div>

</body>
</html>
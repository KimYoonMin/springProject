<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String mode = request.getParameter("mode");
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String select = request.getParameter("select");
	if(mode==null){
		mode = "all";
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="../style.css">
<title>Insert title here</title>
<script type="text/javascript">
 function select(a){
	 document.getElementById('selec').setAttribute('value', a)
 }
 </script>

</head>
<body>
<div align="center">
<hr color="green" width="300">
			<h2>회 원 찾 기</h2>
		
		<form name="f" method="post">
		
		<table border="0" class="outline">
		<tr class="outline">
<select id="selectbox" name="selector" size='1'>      

                    <option value=id >아이디</option>

                    <option value=name >이름</option>
                  
</select>
<input type="hidden" name="selec" value="">
<input type="text" name="select" class="box" maxlength="6">
<input type="submit" value="찾기">
</tr>
</table>
</form>
<hr color="green" width="300">
</div>
</body>
</html>
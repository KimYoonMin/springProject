<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="../style.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<c:if test="${!(empty check)}">
		<script type="text/javascript">
			alert("��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.!")
			history.back()
		</script>
		</c:if>
		
		
		<c:choose>
		<c:when test="${empty delete}">
		<script type="text/javascript">
			alert("���� ����!")
			history.back()
		</script>
		</c:when>
		<c:otherwise>
		<script type="text/javascript">
		alert("��������!")
		location.href="list.brd"
		</script>
		</c:otherwise>
		
</c:choose>
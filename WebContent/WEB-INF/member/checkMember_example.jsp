<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<c:choose>
	<c:when test="${!(empty isMember)}">
	<script type="text/javascript">
		alert("ȸ���̽ʴϴ�. �α������ּ���!!")
		self.close();
	</script>
	</c:when>	
	<c:otherwise>
	<form name="f" action="member.mem" method="post">
		<input type="hidden" name="name" value="${name}">
		<input type="hidden" name="ssn1" value="${ssn1}">
		<input type="hidden" name="ssn2" value="${ssn2}">
	</form>
	<script type="text/javascript">
	alert("ȸ������ �������� �̵��մϴ�.")
	/* location.href="member.jsp" */
	document.f.submit()
	</script>
	</c:otherwise>
</c:choose>

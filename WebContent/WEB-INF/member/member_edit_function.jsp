<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<c:choose>
	<c:when test="${empty edit)}">
	<script type="text/javascript">
		alert("��������!!")
		location.href="memberAll.mem"
		</script>		
	</c:when>	
	<c:otherwise>
		<script type="text/javascript">
		alert("�����Ϸ�!!")
		location.href="memberAll.mem"
		</script>
		</c:otherwise>
</c:choose>
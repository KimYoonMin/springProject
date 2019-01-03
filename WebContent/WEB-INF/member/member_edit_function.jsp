<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<c:choose>
	<c:when test="${empty edit)}">
	<script type="text/javascript">
		alert("수정실패!!")
		location.href="memberAll.mem"
		</script>		
	</c:when>	
	<c:otherwise>
		<script type="text/javascript">
		alert("수정완료!!")
		location.href="memberAll.mem"
		</script>
		</c:otherwise>
</c:choose>
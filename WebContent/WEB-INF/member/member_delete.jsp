<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<c:if test="${!(empty check)}">
		<script type="text/javascript">
		alert("뭐고 이거!!")
		location.href="memberAll.mem"
		</script>
	</c:if>
		
	
	<c:choose>
		<c:when test="${empty delete}">
			<script type="text/javascript">
			alert("멤버삭제 실패!!")
			location.href="memberAll.mem"
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
			alert("멤버삭제 성공!!")
			location.href="memberAll.mem"
			</script>
		</c:otherwise>
	</c:choose>
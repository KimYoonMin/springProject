<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- delete.jsp -->
	<c:if test="${!(empty check)}">
		<script type = "text/javascript">
		alert("�ش� ���̵� �����ϴ�.")
		history.back()
		</script>
	</c:if>

		
		<c:choose>
			<c:when test="${empty delete}">
				<script type="text/javascript">
				alert("�л����� ����!! �л������������ �̵��մϴ�.")
				location.href="student.do"
				</script>
			</c:when>
			<c:otherwise>
				<script type="text/javascript">
				alert("�л����� ����!! �л������������ �̵��մϴ�.")
				location.href="list.do"
				</script>	
			</c:otherwise>
	</c:choose>
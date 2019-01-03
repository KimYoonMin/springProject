<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- delete.jsp -->
	<c:if test="${!(empty check)}">
		<script type = "text/javascript">
		alert("해당 아이디가 없습니다.")
		history.back()
		</script>
	</c:if>

		
		<c:choose>
			<c:when test="${empty delete}">
				<script type="text/javascript">
				alert("학생삭제 실패!! 학생등록페이지로 이동합니다.")
				location.href="student.do"
				</script>
			</c:when>
			<c:otherwise>
				<script type="text/javascript">
				alert("학생삭제 성공!! 학생목록페이지로 이동합니다.")
				location.href="list.do"
				</script>	
			</c:otherwise>
	</c:choose>
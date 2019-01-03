<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- insert.jsp -->

<!-- StudentDAO stdao = new StudentDAO(); -->




<!-- stdto.setId(request.getParameter("id")); -->
<!-- table의 column명, form태그의 name, dto의 멤버필드명은 가능하면 일치시켜주자 -->

	<c:if test="${!(empty check)}">	
	<script type = "text/javascript">
		alert("아이디, 학생명, 학급명을 모두 입력해 주세요!!")
		history.back()
	</script>	
	</c:if>

	<c:choose>
	<c:when test="${empty insert}">
	<script type="text/javascript">
		alert("학생등록 실패!! 학생등록페이지로 이동합니다.")
		location.href="student.do"
		</script>			
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
		alert("학생등록 성공!! 학생목록페이지로 이동합니다.")
		location.href="list.do"
		</script>
		</c:otherwise>	
</c:choose>

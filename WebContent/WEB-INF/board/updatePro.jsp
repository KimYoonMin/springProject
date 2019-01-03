<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<c:if test="${!(empty check)}">
			<script type="text/javascript">
			alert("비밀번호가 틀렸습니다.!")
			history.back()
			</script>
		</c:if>
		<c:choose>
			<c:when test="${empty update}">
			<script type="text/javascript">
			alert("글수정 실패!")
			history.back()
			</script>	
			</c:when>
		<c:otherwise>			
			<script type="text/javascript">
			alert("글수정 성공!")
			location.href="list.brd"
			</script>	
		</c:otherwise>
		</c:choose>
		

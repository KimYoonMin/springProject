<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<c:choose>
		<c:when test="${empty insert}">
		<script type="text/javascript">
		alert("ȸ����� ����!! ȸ�������������� �̵��մϴ�.")
		location.href="memberSsn.mem"
		</script>
		</c:when>
		<c:otherwise>	
		<script type="text/javascript">
		alert("ȸ����� ����!! ������������ �̵��մϴ�.")
		location.href="../../index.jsp"
		</script>
		</c:otherwise>
</c:choose>
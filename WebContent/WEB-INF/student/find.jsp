<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
   <div align="center">
      <hr color="green" width="300">
      <h2>학 생 목 록 페 이 지</h2>
      <hr color="green" width="300">
      <table border="1" width="500">
         <tr bgcolor="yellow">
            <th width="100">아이디</th>
            <th width="150">학생명</th>
            <th width="250">학급명</th>
         </tr>
         <%-- 여기에 DB와 연결하여 데이타를 가져와 출력시켜보시오 --%>
         
         <c:if test="${empty list}">
            <script type="text/javascript">
             alert("학생 정보가 없습니다.")
             location.href="student.jsp";
             </script>
         </c:if>
         <%-- <c:set var="list" value="${list }"/> --%>
         <!-- <script type="text/javascript">
             alert(${dto}"개의 정보를 찾았습니다.")
          </script> -->
          <c:forEach var="dto" items="${list}">
         <tr>
            <td>${dto.id}</td>
            <td>${dto.name}</td>
            <td>${dto.cname}</td>
         </tr>
          </c:forEach>
      </table>
   </div>
</body>
</html>
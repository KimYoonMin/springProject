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
      <h2>�� �� �� �� �� �� ��</h2>
      <hr color="green" width="300">
      <table border="1" width="500">
         <tr bgcolor="yellow">
            <th width="100">���̵�</th>
            <th width="150">�л���</th>
            <th width="250">�б޸�</th>
         </tr>
         <%-- ���⿡ DB�� �����Ͽ� ����Ÿ�� ������ ��½��Ѻ��ÿ� --%>
         
         <c:if test="${empty list}">
            <script type="text/javascript">
             alert("�л� ������ �����ϴ�.")
             location.href="student.jsp";
             </script>
         </c:if>
         <%-- <c:set var="list" value="${list }"/> --%>
         <!-- <script type="text/javascript">
             alert(${dto}"���� ������ ã�ҽ��ϴ�.")
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
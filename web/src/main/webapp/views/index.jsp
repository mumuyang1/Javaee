<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>

  <spring:url value="/lib/js/jquery-1.11.1.min.js" var="jQuery" />
  <script src="${jQuery}"></script>

  <spring:url value="/lib/js/user.js" var="user" />
  <script src="${user}"></script>

    <title></title>
</head>
<body>

<table align="center" border="2" bgcolor="#ffc0cb">
  <tr align="center">
    <td>姓名</td>
    <td>性别</td>
    <td>邮箱</td>
    <td>年龄</td>
    <td>删除</td>
    <td>更新用户信息</td>
  </tr>
  <c:forEach var = "user" items="${userList}" >
  <tr align="center">
    <td><c:out value="${user.name}" /></td>
    <td><c:out value="${user.gender}" /></td>
    <td><c:out value="${user.mailbox}" /></td>
    <td><c:out value="${user.age}" /></td>
    <td><a href="javascript:;"onclick="deleteUser(<c:out value="${user.userId}" />);">删除</a></td>
    <td>
      <button type="button" style="border-color: white" align="center" onclick="location = '/web/users/<c:out value="${user.userId}"/>'">更新用户信息</button>
               </td>
   </tr>
  </c:forEach>
</table></br>

<div align="center"><button type="button" style="border-color: pink" onclick="location = '/web/users/creation'">增加用户</button></div>

</body>
</html>

<%@ page import="com.tw.core.dao.UserDao" %>
<%@ page import="com.tw.core.entity.User" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yzli
  Date: 7/7/15
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
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
  <c:forEach var = "user" items="${usersList}" >
  <tr align="center">
    <td><c:out value="${user.name}" /></td>
    <td><c:out value="${user.gender}" /></td>
    <td><c:out value="${user.mailbox}" /></td>
    <td><c:out value="${user.age}" /></td>
    <td><a  href="./deleteUser?userId=<c:out value="${user.userId}" />">删除</a></td>
    <td>
      <button type="button" style="border-color: white" align="center" onclick="location = '/web/update?userId=<c:out value="${user.userId}"/>'">更新用户信息</button>
               </td>
   </tr>
  </c:forEach>
</table></br>

<div align="center"><button type="button" style="border-color: pink" onclick="location = 'insertUser.jsp'">增加用户</button></div>

</body>
</html>

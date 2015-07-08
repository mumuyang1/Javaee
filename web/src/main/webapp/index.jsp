<%@ page import="com.tw.core.dao.UserDao" %>
<%@ page import="com.tw.core.entity.User" %>
<%@ page import="java.util.List" %>
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

<%
  UserDao userDao = new UserDao();
  List<User> userList = userDao.getUsers();%>

<table border="1">
  <tr>
    <td>姓名</td>
    <td>性别</td>
    <td>邮箱</td>
    <td>年龄</td>
    <td>删除</td>
  </tr>
  <tr>
    <% for (User user : userList){%>
    <td><%= user.getName()%></td>
    <td><%= user.getGender()%></td>
    <td><%= user.getMailbox()%></td>
    <td><%= user.getAge()%></td>
    <td><a  href="/web/deleteUser?userId=<%=user.getUserId()%>">删除</a></td>
    <%--<td><input type="button" onclick="<% userDao.deleteUser(user.getUserId());%>" value="删除"></td>--%>
   </tr>
  <% } %>
</table>

<button type="button" onclick="location = 'insertUser.jsp'">增加用户</button>

</body>
</html>

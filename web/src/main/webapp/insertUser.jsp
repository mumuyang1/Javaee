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

<h3>增加用户</h3>

<form action="/web/deleteUser" method="post">
    姓   名: <input type="text" name="name" />
    性   别: 男<input name="gender" type="radio" value="男" />女<input name="gender" type="radio" value="女" />
    邮   箱: <input type="text" name="mailbox" />
    年   龄: <input type="number" min="1" max="110" name="age" />
    <input type="submit" value="确定" />
</form>

</body>
</html>

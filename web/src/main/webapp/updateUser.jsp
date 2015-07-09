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

<h3>更新用户信息</h3>

<form action="/web/update" method="post">

    <input type="text" name="id" value="${user.userId}" hidden="hidden" />

    姓   名: <input type="text" name="name" value="${user.name}">

    <c:if test="${user.gender == '男'}">
    性   别: 男<input name="gender" type="radio" value="男" checked/>女<input name="gender" type="radio" value="女" />
    </c:if>
    <c:if test="${user.gender == '女'}">
    性   别: 男<input name="gender" type="radio" value="男" />女<input name="gender" type="radio" value="女" checked />
    </c:if>
    邮   箱: <input type="text" name="mailbox" value="${user.mailbox}">
    年   龄: <input type="number" min="1" max="110" name="age" value="${user.age}"/>
    <input type="submit" value="确定" />
</form>
</body>
</html>
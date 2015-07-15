<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
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
    <spring:url value="/lib/js/jquery-1.11.1.min.js" var="jQuery" />
    <script src="${jQuery}"></script>
    <spring:url value="/lib/js/updateUser.js" var="updateUserJs" />
    <script src="${updateUserJs}"></script>
    <title></title>
</head>
<body>

<h3>更新用户信息</h3>

<form id="updateUserInfoForm">

    <input id="idInput" type="text" name="id" value="${user.userId}" hidden="hidden" />

    姓   名: <input style="border-color: pink" type="text" name="name" value="${user.name}">
    性   别:男<input name="gender" type="radio" value="男" <c:if test="${user.gender == '男'}">checked </c:if>/>
            女<input name="gender" type="radio" value="女" <c:if test="${user.gender == '女'}">checked </c:if>/>
    邮   箱: <input style="border-color: pink" type="text" name="mailbox" value="${user.mailbox}">
    年   龄: <input style="border-color: pink" type="number" min="1" max="110" name="age" value="${user.age}"/>
    密   码: <input style="border-color: pink" type="password" name="password" value="${user.password}"/>
    <input style="border-color: wheat"  type="submit" value="确定" />
</form>

</body>
</html>

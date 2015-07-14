<%--
  Created by IntelliJ IDEA.
  User: yzli
  Date: 7/13/15
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title></title>
</head>
  <h3 align="center">登录</h3>

  <div align="center">
  <form action="/web/login" method="post">
    用户名:&nbsp;<input type="text" name="name"></br>
    密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input type="password" name="password"/></br></br>
    <input  align="center" style="border-color: wheat" type="submit" value="登录" />
  </form>
  </div>

</body>
</html>

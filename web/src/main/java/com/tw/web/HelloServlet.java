package com.tw.web;

import com.tw.core.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

//        PrintWriter out = res.getWriter();
//
//        out.println(new Service().service());
//        out.close();
//        res.setCharacterEncoding("UTF-8");
//        res.setContentType("text/html;character=utf-8");

//        UserDao userDao = new UserDao();
//
//        try {
//            List<User>  userList = userDao.getUsers();
//            PrintWriter out = res.getWriter();
//
//            out.println(userList.get(0).getName());
//            out.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        UserDao userDao = new UserDao();
//        try {
//            List<User> userList = userDao.getUsers();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
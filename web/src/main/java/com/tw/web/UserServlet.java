package com.tw.web;

import com.tw.core.entity.User;
import com.tw.core.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.setAttribute("usersList", userService.getUsers());
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String mailbox = req.getParameter("mailbox");
        int age = Integer.parseInt(req.getParameter("age"));

        User user = new User(name, gender, mailbox, age);

        UserService userService = new UserService();
        userService.insertUser(user);

        res.sendRedirect("/web");
    }
}
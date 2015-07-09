package com.tw.web;

import com.tw.core.entity.User;
import com.tw.core.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yzli on 7/8/15.
 */
public class UpdateUserServlet extends HttpServlet {

    private UserService userService = new UserService();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.setAttribute("user", userService.getUserBy(Integer.parseInt(req.getParameter("userId"))));
        req.getRequestDispatcher("updateUser.jsp").forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) {

        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String mailbox = req.getParameter("mailbox");
        int age = Integer.parseInt(req.getParameter("age"));
        int id = Integer.parseInt(req.getParameter("id"));
        User user = new User(id, name, gender, mailbox, age);
        UserService userService = new UserService();
        userService.updateUser(user);

        try {
            res.sendRedirect("/web");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



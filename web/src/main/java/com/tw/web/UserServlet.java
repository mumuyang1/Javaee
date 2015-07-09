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
public class UserServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("userId"));
        UserService userService = new UserService();


            userService.deleteUserBy(id);
            res.sendRedirect("/web");

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


        System.out.println("99999999999");
        String name = req.getParameter("name");
        System.out.println(name);
        String gender = req.getParameter("gender");
        String mailbox = req.getParameter("mailbox");
        int age = Integer.parseInt(req.getParameter("age"));
        User  user = new User(name,gender,mailbox,age);
        UserService userService = new UserService();
        userService.insertUser(user);

        res.sendRedirect("/web");
    }


}

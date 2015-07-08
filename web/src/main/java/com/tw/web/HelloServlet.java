package com.tw.web;

import com.tw.core.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        UserService userService = new UserService();

        req.setAttribute("usersList",userService.getUsers());

        req.getRequestDispatcher("index.jsp").forward(req,res);
    }
}
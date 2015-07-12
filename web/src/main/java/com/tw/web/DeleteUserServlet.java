package com.tw.web;

import com.tw.core.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yzli on 7/8/15.
 */
public class DeleteUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("userId"));

        UserService userService = new UserService();
        userService.deleteUserBy(id);

        res.sendRedirect("/web");
    }


}

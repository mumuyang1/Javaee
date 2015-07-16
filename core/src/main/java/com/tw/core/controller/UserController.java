package com.tw.core.controller;

import com.tw.core.entity.User;
import com.tw.core.service.UserService;
import com.tw.core.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yzli on 7/12/15.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showIndex(HttpSession session, HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();
        String user = (String) session.getAttribute("user");

        if (user == "login") {
            modelAndView.setViewName("index");
            modelAndView.addObject("userList", userService.getUsers());
            return modelAndView;
        } else {

            modelAndView.setViewName("login");
            CookieUtil.addCurrentURLToCookies(request, response);
            return modelAndView;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") int id) {

        userService.deleteUserBy(id);
    }

    @RequestMapping(value = "/creation", method = RequestMethod.POST)
    public ModelAndView insertUser(@RequestParam String name, String gender, String mailbox, int age, String password) {

        User user = new User(name, gender, mailbox, age, password);

        userService.insertUser(user);

        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/creation", method = RequestMethod.GET)
    public ModelAndView getInsertPage(HttpSession session, HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();
        String user = (String) session.getAttribute("user");

        if (user == "login") {
            modelAndView.setViewName("insertUser");
            return modelAndView;
        } else {
            modelAndView.setViewName("login");
            CookieUtil.addCurrentURLToCookies(request, response);
            return modelAndView;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getUserById(@PathVariable int id, HttpSession session, HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();
        String user = (String) session.getAttribute("user");

        if (user == "login") {
            modelAndView.setViewName("updateUser");
            modelAndView.addObject("user", userService.getUserBy(id));
            return modelAndView;
        } else {
            CookieUtil.addCurrentURLToCookies(request, response);

            modelAndView.setViewName("login");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable int id, @RequestParam String name, String gender, String mailbox, int age, String password) {

        User user = new User(id, name, gender, mailbox, age, password);

        userService.updateUser(user);
    }


}

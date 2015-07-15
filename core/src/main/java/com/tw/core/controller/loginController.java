package com.tw.core.controller;

import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yzli on 7/13/15.
 */
@RestController
@RequestMapping("/")
public class loginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getLoginPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        return modelAndView;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView getLogin(@CookieValue("url") String fromUrl,@RequestParam String name, String password, HttpSession session, HttpServletResponse response, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        System.out.println(fromUrl+"2222222");

        if (userService.login(name, password)) {

            session.setAttribute("user", "login");

            if (fromUrl.equals("http://localhost:8080/web/")) {

                ModelAndView modelAndView1 = new ModelAndView("redirect:/users");
                modelAndView.addObject("user", name);

                return modelAndView1;
            } else {

                ModelAndView modelAndView1 = new ModelAndView("redirect:" + fromUrl);
                eraseCookie(request, response);

                modelAndView.addObject("user", name);

                Cookie cookie = new Cookie("url",fromUrl);
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);

            System.out.println(fromUrl+"3333333333");
                return modelAndView1;
            }
        } else {

            System.out.println("登录失败+++++++++++++++++++");
            return new ModelAndView("redirect:/");
        }
    }

    private void eraseCookie(HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null)
            for (int i = 0; i < cookies.length; i++) {
                cookies[i].setValue(null);
                cookies[i].setPath("/");
                cookies[i].setMaxAge(0);
                resp.addCookie(cookies[i]);
            }
    }
}

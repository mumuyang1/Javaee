package com.tw.core.controller;

import com.tw.core.service.UserService;
import com.tw.core.utils.CookieUtil;
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
    public ModelAndView getLoginPage(HttpServletResponse response, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        CookieUtil.addCurrentURLToCookies(request, response);

        return modelAndView;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView getLogin(@CookieValue("url") String fromUrl,@RequestParam String name, String password, HttpSession session, HttpServletResponse response, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        if (userService.login(name, password)) {

            session.setAttribute("user", "login");

            if (fromUrl.equals("http://localhost:8080/web/")) {

                ModelAndView modelAndView1 = new ModelAndView("redirect:/users");
                modelAndView.addObject("user", name);

                return modelAndView1;
            } else {

                ModelAndView modelAndView1 = new ModelAndView("redirect:" + fromUrl);

                deleteFromUrlInCookie(response,fromUrl);

                return modelAndView1;
            }
        } else {

            System.out.println("登录失败+++++++++++++++++++");
            return new ModelAndView("redirect:/");
        }
    }

    private void deleteFromUrlInCookie(HttpServletResponse response, String todeleteUrl) {

        Cookie cookie = new Cookie("url",todeleteUrl);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}

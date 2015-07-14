package com.tw.core.controller;

import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView getLogin(@RequestParam String name, String password,HttpSession session) {

        ModelAndView modelAndView= new ModelAndView();
        System.out.println(session.getId()+"--------------------------------");

        if(userService.login(name, password)){

            System.out.println("登陆成功+++++++++++++++");
            session.setAttribute("user", "login");
            //setting session to expiry in 30 mins
            ModelAndView modelAndView1 = new ModelAndView("redirect:/users");
            modelAndView.addObject("user",name);

            return modelAndView1;
        }else{

            System.out.println("登录失败+++++++++++++++++++");
            return new ModelAndView("redirect:/");
        }
    }

}

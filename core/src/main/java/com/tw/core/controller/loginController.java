package com.tw.core.controller;

import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    public ModelAndView getLogin(@RequestParam String name, String password,HttpSession session, HttpServletRequest request) {

        ModelAndView modelAndView= new ModelAndView();

        if(userService.login(name, password)){

            session.setAttribute("user", "login");
            String fromUrl = request.getHeader("referer");

            if (fromUrl.equals("http://localhost:8080/web/")){

                ModelAndView modelAndView1 = new ModelAndView("redirect:/users");
                modelAndView.addObject("user",name);

                return modelAndView1;
            }else {

                ModelAndView modelAndView1 = new ModelAndView("redirect:"+fromUrl);
                modelAndView.addObject("user",name);

                return modelAndView1;
            }
        }else{

            System.out.println("登录失败+++++++++++++++++++");
            return new ModelAndView("redirect:/");
        }
    }

}

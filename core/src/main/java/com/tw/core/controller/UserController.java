package com.tw.core.controller;

import com.tw.core.entity.User;
import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yzli on 7/12/15.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
//        modelAndView.addObject( " 需要放到 model 中的属性名称 " , " 对应的属性值，它是一个对象 " );
        modelAndView.addObject( "usersList" , userService.getUsers());

        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus( HttpStatus.OK )
    public void deleteUser(@PathVariable( "id" ) int id) {

        userService.deleteUserBy(id);
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public ModelAndView insertUser(@RequestParam String name,String gender,String mailbox,int age) {

        User user = new User(name, gender, mailbox, age);

        userService.insertUser(user);

        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.GET)
    public ModelAndView  getInsertPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("insertUser");

        return modelAndView;
    }


    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView getUserById(@RequestParam int userId) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateUser");

        modelAndView.addObject("user", userService.getUserBy(userId));
        return modelAndView;
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateUser(@RequestParam String name,String gender,String mailbox,int age,int id) {

        User user = new User(id, name, gender, mailbox, age);

        userService.updateUser(user);

        return new ModelAndView("redirect:/users");
    }
}

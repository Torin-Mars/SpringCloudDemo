package com.mtl.user.controller;

import com.mtl.user.pojo.User;
import com.mtl.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MTL on 2019/12/12
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    public User getUser(@PathVariable("id") Long id){
        return userService.queryById(id);
    }

    @RequestMapping("/get")
    public List<User> get(){
        return userService.getAll();
    }
}

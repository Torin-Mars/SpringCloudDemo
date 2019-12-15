package com.mtl.consumer.controller;

import com.mtl.consumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MTL on 2019/12/12
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{id}")
    @HystrixCommand
    public User queryById(@PathVariable("id") Long id) {

        String url = "http://user-service/user/" + id;
        //String url = "http://localhost:8081/user/" + id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }

    public User queryByIdFallBack(Long id) {
        User user = new User();
        user.setUserName("未知用户错误");
        return user;
    }

    @RequestMapping("/")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public List<User> get(){
        return new ArrayList<>();
    }
}

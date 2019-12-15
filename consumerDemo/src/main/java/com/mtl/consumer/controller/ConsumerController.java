package com.mtl.consumer.controller;

import com.mtl.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by MTL on 2019/12/12
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {

        String url = "http://user-service/user/" + id;
        //String url = "http://localhost:8081/user/" + id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}

package com.springcloud.controller;

import com.springcloud.entity.ChatUser;
import com.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@RequestMapping("/provider")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ChatUser findUserById(@PathVariable Integer id)
    {
        return userService.findUserById(id);
    }
}

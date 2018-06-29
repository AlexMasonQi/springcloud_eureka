package com.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.springcloud.entity.ChatUser;
import com.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableEurekaClient
public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    private EurekaClient discoveryClient;

    @GetMapping("/user/{id}")
    public ChatUser findUserById(@PathVariable Integer id)
    {
        return userService.findUserById(id);
    }

    @GetMapping("/allUser")
    public List<ChatUser> selectAllUser()
    {
        return userService.selectAllUsers();
    }

    @GetMapping("/instace-info")
    public String serviceUrl()
    {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
        return instance.getHomePageUrl();
    }
}

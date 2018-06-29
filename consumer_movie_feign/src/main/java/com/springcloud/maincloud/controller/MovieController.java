package com.springcloud.maincloud.controller;

import com.springcloud.maincloud.entity.ChatUser;
import com.springcloud.maincloud.feign.MovieFeignClient;
import com.springcloud.maincloud.feign.MovieFeignClient2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MovieFeignClient movieFeignClient;

    @Autowired
    private MovieFeignClient2 movieFeignClient2;

    @GetMapping("/user/{id}")
    public ChatUser getUserById(@PathVariable Integer id)
    {
        return movieFeignClient.getUserById(id);
    }

    @GetMapping("/allUser")
    public List<ChatUser> selectAllUsers()
    {
        return movieFeignClient.selectAllUsers();
    }

    @GetMapping("/{serviceName}")
    public String getEurekaInfoByServiceName(@PathVariable String serviceName)
    {
        return movieFeignClient2.getEurekaInfoByServiceName(serviceName);
    }
}

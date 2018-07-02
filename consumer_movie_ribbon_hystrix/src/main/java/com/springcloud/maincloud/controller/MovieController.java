package com.springcloud.maincloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.maincloud.entity.ChatUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/user/{id}")
    @HystrixCommand(fallbackMethod = "getUserByIdCallBack")
    public ChatUser getUserById(@PathVariable Integer id)
    {
        logger.info("Get user " + id + "successfully!");
        return restTemplate.getForObject("http://microservice-provider-user/provider_user/user/" + id, ChatUser.class);
    }

    public ChatUser getUserByIdCallBack(Integer id)
    {
        logger.warn("Cannot find service, start callback method!");
        ChatUser chatUser = new ChatUser();
        chatUser.setId(0);

        return chatUser;
    }

//    @GetMapping("/testRibbon")
//    public String testRibbonBalancer()
//    {
//        ServiceInstance instanceUser = loadBalancerClient.choose("MICROSERVICE-PROVIDER-USER");
//        System.out.println("user: " + instanceUser.getServiceId() + " === " + instanceUser.getHost() + ": " + instanceUser.getPort());
//        ServiceInstance instanceUser2 = loadBalancerClient.choose("MICROSERVICE-PROVIDER-USER2");
//        System.out.println("user2: " + instanceUser2.getServiceId() + " === " + instanceUser2.getHost() + ": " + instanceUser2.getPort());
//
//        return "200: OK";
//    }
}

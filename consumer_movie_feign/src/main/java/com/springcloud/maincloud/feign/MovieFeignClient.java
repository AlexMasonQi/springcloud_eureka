package com.springcloud.maincloud.feign;

import com.springcloud.maincloud.config.FeignConfig;
import com.springcloud.maincloud.entity.ChatUser;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "microservice-provider-user", configuration = FeignConfig.class)
public interface MovieFeignClient
{
    @RequestLine("GET /provider_user/user/{id}")
    public ChatUser getUserById(@Param("id") Integer id);

    @RequestLine("GET /provider_user/allUser")
    public List<ChatUser> selectAllUsers();
}

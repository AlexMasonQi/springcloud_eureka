package com.springcloud.maincloud.feign;

import com.springcloud.maincloud.config.FeignConfig;
import com.springcloud.maincloud.entity.ChatUser;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "microservice-provider-user", configuration = FeignConfig.class, fallbackFactory = MovieFallback.class)
public interface MovieFeignClient
{
    @RequestLine("GET /user/{id}")
    ChatUser getUserById(@Param("id") Integer id);
}

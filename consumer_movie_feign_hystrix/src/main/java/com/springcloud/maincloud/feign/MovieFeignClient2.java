package com.springcloud.maincloud.feign;

import com.springcloud.maincloud.config.FeignConfig2;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "eurekaDemo", url = "http://47.104.84.122:9093", configuration = FeignConfig2.class)
public interface MovieFeignClient2
{
    @RequestLine("GET /eureka/apps/{serviceName}")
    String getEurekaInfoByServiceName(@Param("serviceName") String serviceName);
}

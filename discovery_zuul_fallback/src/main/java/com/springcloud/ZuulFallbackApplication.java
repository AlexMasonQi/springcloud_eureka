package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.springcloud"})
public class ZuulFallbackApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ZuulFallbackApplication.class, args);
    }
}

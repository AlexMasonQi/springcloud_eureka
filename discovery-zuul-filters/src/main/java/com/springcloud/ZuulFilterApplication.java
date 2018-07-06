package com.springcloud;

import com.springcloud.filter.FeignZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
@EnableZuulProxy
public class ZuulFilterApplication
{
    @Bean
    public FeignZuulFilter zuulFilter()
    {
        return new FeignZuulFilter();
    }

    public static void main(String[] args)
    {
        SpringApplication.run(ZuulFilterApplication.class, args);
    }
}

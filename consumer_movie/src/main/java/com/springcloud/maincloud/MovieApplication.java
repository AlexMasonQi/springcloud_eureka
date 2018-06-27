package com.springcloud.maincloud;

import com.springcloud.config.RibbonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICE-PROVIDER-USER", configuration = RibbonConfig.class)
public class MovieApplication
{
    @Autowired
    private RestTemplateBuilder builder;

    //make the RestTemplate have the ability of load balancing
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate()
    {
        return builder.build();
    }

    public static void main(String[] args)
    {
        SpringApplication.run(MovieApplication.class, args);
    }
}

package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration
public class MovieApplication
{
    @Bean
    public RestTemplate restTemplateBuilder(RestTemplateBuilder builder)
    {
        return builder.build();
    }

    public static void main(String[] args)
    {
        SpringApplication.run(MovieApplication.class, args);
    }
}

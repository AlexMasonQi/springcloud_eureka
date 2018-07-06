package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSidecar
public class SidecarApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SidecarApplication.class, args);
    }
}

package com.springcloud.maincloud.config;

import com.springcloud.maincloud.ExcludeFromComponentScan;
import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeFromComponentScan
public class FeignConfig
{
    @Bean
    public Contract feignContract()
    {
        return new feign.Contract.Default();
    }

    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }
}

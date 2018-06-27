package com.springcloud.config;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig
{
    @Autowired
    private IClientConfig config;

    @Bean
    public IClientConfig clientConfig()
    {
        return new DefaultClientConfigImpl();
    }

    @Bean
    public IRule ribbonRule()
    {
        return new RandomRule();
    }
}

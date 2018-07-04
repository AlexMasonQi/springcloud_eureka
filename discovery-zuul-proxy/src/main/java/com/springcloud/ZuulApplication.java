package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication
{
    //open the hystrix dashboard(Spring Boot Version 2.0+)
//    @Bean
//    public ServletRegistrationBean getServlet()
//    {
//        ZuulServlet zuulServlet = new ZuulServlet();
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(zuulServlet);
//        registrationBean.setLoadOnStartup(1);
//        registrationBean.addUrlMappings("/actuator/routes");
//        registrationBean.addUrlMappings("/actuator/routes/details");
//        registrationBean.setName("ZuulServlet");
//
//        return registrationBean;
//    }

    public static void main(String[] args)
    {
        SpringApplication.run(ZuulApplication.class, args);
    }
}

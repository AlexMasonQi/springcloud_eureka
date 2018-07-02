package com.springcloud.maincloud.feign;

import com.springcloud.maincloud.entity.ChatUser;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MovieFallback implements FallbackFactory<MovieFeignClient>
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public MovieFeignClient create(Throwable throwable)
    {
        logger.info("preparing to print error log!");
        return id ->
        {
            ChatUser user = new ChatUser();
            user.setId(-1);

            return user;
        };
    }
}

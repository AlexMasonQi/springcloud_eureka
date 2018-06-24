package com.springcloud.dao;

import com.springcloud.entity.ChatUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao
{
    public ChatUser selectUserById(@Param("id") Integer id);
}

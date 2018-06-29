package com.springcloud.dao;

import com.springcloud.entity.ChatUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao
{
    ChatUser selectUserById(@Param("id") Integer id);

    List<ChatUser> selectAllUsers();
}

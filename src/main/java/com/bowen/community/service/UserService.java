package com.bowen.community.service;

import com.bowen.community.dao.UserMapper;
import com.bowen.community.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Users findUserById(int id){
        return userMapper.selectById(id);
    }
}

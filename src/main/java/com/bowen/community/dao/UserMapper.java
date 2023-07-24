package com.bowen.community.dao;

import com.bowen.community.entity.Users;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    Users selectById(int id);
    Users selectByName(String name);
    Users selectByEmail(String email);
    int insertUsers(Users user);
    int updateStatus(int userid, int status);
    int updateHeader(int userid, String headerUrl);
    int updatePassword(int userid, String password);
}

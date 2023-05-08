package com.bowen.community.dao;

import com.bowen.community.entity.Recipients;
import org.apache.ibatis.annotations.Mapper;

//使用Mybatis的索引注解表示Dao类
@Mapper
public interface UserMapper {
    Recipients selectById(int id);
    Recipients selectByName(String name);
    Recipients selectByEmail(String email);
    int insertRecipients(Recipients recipients);
    int updateStatus(int id, int status);
    int updateHeader(int id, String headerUrl);
    int updatePassword(int id, String password);
}

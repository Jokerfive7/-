package com.bowen.community.dao;

import org.springframework.stereotype.Repository;

@Repository("hi")
//数据库的bean使用该注解用户LoC索引
public class AlphaDaoConcrete implements AlphaDao{
    @Override
    public String select() {
        return "Hi";
    }
}

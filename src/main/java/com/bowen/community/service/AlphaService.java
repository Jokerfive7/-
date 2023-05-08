package com.bowen.community.service;

import com.bowen.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope("prototype")
//业务类索引使用
public class AlphaService {

    //不同类之间都可以使用注解来依赖注入，而不是重新创建对象。
    @Autowired
    private AlphaDao alphaDao;
    public String useDao(){
        return alphaDao.select();
    }

    public AlphaService(){
        System.out.println("FIRST");

    }

    //初始化注解
    @PostConstruct
    public void initialize(){
        System.out.println("initialize");

    }

    //销毁注解
    @PreDestroy
    public void destory(){
        System.out.println("destory");

    }


}

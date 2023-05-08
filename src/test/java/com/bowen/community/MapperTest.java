package com.bowen.community;

import com.bowen.community.dao.UserMapper;
import com.bowen.community.entity.Recipients;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser(){
        Recipients recipients = userMapper.selectById(4396);
        System.out.println(recipients);

        recipients = userMapper.selectByName("Jackeylove");
        System.out.println(recipients);

        recipients = userMapper.selectByEmail("546782121@qq.com");
        System.out.println(recipients);

    }

    @Test
    public void testInsertUser(){
        Recipients recipients = new Recipients();
        recipients.setId(2200);
        recipients.setActivationCode("TYU9");
        recipients.setCreateTime(new Date());
        recipients.setEmail("79463154@qq.com");
        recipients.setPassword("456789");
        recipients.setSalt("QWERT");
        recipients.setStatus(1);
        recipients.setType(2);
        recipients.setHeaderUrl("http://localhost:8080/");
        recipients.setUsername("xiaohu");
        int row = userMapper.insertRecipients(recipients);

    }

    @Test
    public void testUpdateUser(){
        userMapper.updateHeader(4396,"xxx");
        userMapper.updatePassword(4399,"GBW");
        userMapper.updateStatus(5438, 0);

    }
}

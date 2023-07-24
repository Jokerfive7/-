package com.bowen.community;

import com.bowen.community.dao.UserMapper;
import com.bowen.community.entity.Users;
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
        Users user = userMapper.selectById(43961);
        System.out.println(user);

        user = userMapper.selectByName("Jackeylove1");
        System.out.println(user);

        user = userMapper.selectByEmail("546782121@gmail.com");
        System.out.println(user);

    }

    @Test
    public void testInsertUser(){
        Users user = new Users();
        user.setId(2200);
        user.setActivationCode("TYU9");
        user.setCreateTime(new Date());
        user.setEmail("79463154@gmail.com");
        user.setPassword("456789");
        user.setSalt("QWERT");
        user.setStatus(1);
        user.setType(2);
        user.setHeaderUrl("http:");
        user.setUsername("xiaohu");
        int row = userMapper.insertUsers(user);
        System.out.println(row);

    }

    @Test
    public void testUpdateUser(){
        userMapper.updateHeader(43961,"xxx");
        userMapper.updatePassword(43961,"GBW");
        userMapper.updateStatus(43961, 1);

        System.out.println(userMapper.selectById(43961));
    }
//
//    @Autowired
//    private DiscussPostMapper discussPostMapper;
//    @Test
//    public void testSelectPost(){
//        List<DiscussPost> list = discussPostMapper.selectDiscussPost(0,0,10);
//        for (DiscussPost discussPosts: list){
//            System.out.println(discussPosts);
//        }
//
//        System.out.println(discussPostMapper.selectDiscussRows(0));
//
//    }
}

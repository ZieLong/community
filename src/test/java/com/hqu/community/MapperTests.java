package com.hqu.community;

import com.hqu.community.dao.DiscussPostMapper;
import com.hqu.community.dao.UserMapper;
import com.hqu.community.entity.DiscussPost;
import com.hqu.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(5);
        System.out.println(user);
        User user1 = userMapper.selectByEmail("sunquan@qq.com");
        System.out.println(user1);
        User user2 = userMapper.selectByName("zhugeiang");
        System.out.println(user2);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("MaChao");
        user.setPassword("123456");
        user.setSalt("absd");
        user.setEmail("Machao@163.com");
        user.setHeaderUrl("http://www.nowcode.com/110.png");
        user.setCreateTime(new Date());

        int row = userMapper.insertUser(user);
        System.out.println(row);
        System.out.println(user.getId());
    }


    @Test
    public void updateUser() {
        int rows = userMapper.updateStatus(11,1);
        System.out.println(rows);
        rows = userMapper.updateHeader(11, "http://www.nowcode.com/123.png");
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0,0,10);
        for(DiscussPost post : list) {
            System.out.println(post);
        }
        int total = discussPostMapper.selectDiscussPostRows(1);
        System.out.println(total);
    }

}

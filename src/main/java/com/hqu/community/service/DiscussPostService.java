package com.hqu.community.service;

import com.hqu.community.dao.DiscussPostMapper;
import com.hqu.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts(int userId, int offser, int limit) {
        return discussPostMapper.selectDiscussPosts(userId, offser, limit);
    }



    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }

}

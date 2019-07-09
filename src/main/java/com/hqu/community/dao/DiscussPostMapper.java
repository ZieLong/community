package com.hqu.community.dao;

import com.hqu.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(@Param("userId") int userId,
                                         @Param("offset") int offset,
                                         @Param("limit") int limit);
    //@param注解用于给参数取悲鸣，
    //如果参数里只有一个参数，并且再<if>里使用，必须取别名
    int selectDiscussPostRows(@Param("userId") int userId);

}

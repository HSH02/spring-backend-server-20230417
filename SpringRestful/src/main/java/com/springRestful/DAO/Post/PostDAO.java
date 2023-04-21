package com.springRestful.DAO.Post;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.springRestful.Entity.Post.Posts;

@Mapper
public interface PostDAO {
    List<Posts> findPost();
}



package com.springRestful.Service.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springRestful.CustomTypes.CustomResponse;
import com.springRestful.DAO.Post.PostDAO;
import com.springRestful.Entity.Post.Posts;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostDAO postDAO;
    
    public List<Posts> getPosts() {
        return postDAO.findPost();
    }
    
    public CustomResponse createPost(Posts post) {
    	String title = post.getTitle();
    	String Content = post.getPostContent();
    	
    	return null;
    }
    
}

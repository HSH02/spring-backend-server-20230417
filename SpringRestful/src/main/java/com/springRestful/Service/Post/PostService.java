package com.springRestful.Service.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springRestful.CustomTypes.CustomResponse;
import com.springRestful.DAO.Post.PostDAO;
import com.springRestful.DTO.Post.GetPostCreateRequest;
import com.springRestful.DTO.Post.PostCreateInfo;
import com.springRestful.DTO.Post.PostCreateCategory;
import com.springRestful.DTO.Post.PostCreateCategoryMap;
import com.springRestful.Entity.Post.Posts;
import com.springRestful.Entity.User.Users;
import com.springRestful.Service.User.UserService;

import java.util.List;

@Service
public class PostService {
	
    @Autowired
    private PostDAO postDAO;
    
    @Autowired
    private UserService userService;
    
    public CustomResponse createPost(GetPostCreateRequest postCreateRequest) {
    	
    	Users user = userService.findUserCredentialsByUuid(postCreateRequest.getUuid());
    	    	
    	PostCreateInfo postCreateInfo = new PostCreateInfo();    	
    	postCreateInfo.setUserName(user.getUserName());
    	postCreateInfo.setUserId(user.getUserId());
    	postCreateInfo.setPostType(postCreateRequest.getBoardType());
    	postCreateInfo.setTitle(postCreateRequest.getTitle());
    	postCreateInfo.setContent(postCreateRequest.getContent());
           	    	    	
    	int postId = postDAO.createPost(postCreateInfo);    	 
    	    
    	if(postCreateRequest.getCategories() == null || (postCreateRequest.getCategories().length == 0)) {
    		
    	}else {    	
    		PostCreateCategory postCreateCategory = new PostCreateCategory();
    		PostCreateCategoryMap postCreateCategoryMap = new PostCreateCategoryMap();
    		
    		for(String categoryName : postCreateRequest.getCategories()) {
    			
    			Integer categoryId = postDAO.getCategoryId(categoryName);
    			
    			if(categoryId.equals(0)) {    				
    				postCreateCategory.setCategoryName(categoryName);    				
        			categoryId = postDAO.createCategoryIfNotExists(postCreateCategory);
    			}    			    	
    			
        			postCreateCategoryMap.setPostId(postId);
        			postCreateCategoryMap.setCategoryId(categoryId);
        			postDAO.createPostCategoryMap(postCreateCategoryMap);
    		}
    	}
    	 
    	    	    	    	 
    	return new CustomResponse(true, "게시글 등록이 완료되었습니다");    	
    }
    
    public List<Posts> getPosts() {
        return postDAO.findPost();
    }          
}



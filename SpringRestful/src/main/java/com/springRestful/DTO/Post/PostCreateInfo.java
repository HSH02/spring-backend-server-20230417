package com.springRestful.DTO.Post;

import lombok.Data;

@Data
public class PostCreateInfo {	
	private int postId;
	private String userId;
    private String userName;
    private String postType;
    private String title;
    private String content;
}


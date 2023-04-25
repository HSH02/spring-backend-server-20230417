package com.springRestful.DTO.Post;

import lombok.Data;

@Data
public class GetPostCreateRequest {	
    private String title;
    private String boardType;
    private String content;
    private String[] categories;
    private String uuid;
}

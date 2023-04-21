package com.springRestful.Entity.Post;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;


@Data
@ToString
@Entity
@Table(name = "post")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private String postId;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "userId")
    private String userId;
    
    @Column(name = "post_content")
    private String postContent;
    
    @Column(name = "views")
    private String views;
    
    @Column(name = "created_date")
    private String  createdDate;
    
    @Column(name = "edit_date")
    private String  editDate;
    
    @Column(name = "delete_date")
    private String  deleteDate;

}

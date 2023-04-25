package com.springRestful.Entity.User;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private String userId;
    
    @Column(name = "uuid")
    private String uuid;
    
    @Column(name = "user_name")
    private String userName;
    
    @Column(name = "user_password")
    private String userPassword;
    
    @Column(name = "user_role")
    private String userRole;
    
    @Column(name = "user_email")
    private String userEmail;
    
    @Column(name = "created_date")
    private String createdDate;
    
    @Column(name = "delete_date")
    private String deleteDate;

}

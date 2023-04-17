package com.springRestful.Entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

import java.time.LocalDateTime;

@Data
@ToString
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private String user_id;
    
    @Column(name = "user_name")
    private String user_name;
    
    @Column(name = "user_password")
    private String user_password;
    
    @Column(name = "user_role")
    private String user_role;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "created_date")
    private String  created_date;
    
    @Column(name = "delete_date")
    private String delete_date;

}

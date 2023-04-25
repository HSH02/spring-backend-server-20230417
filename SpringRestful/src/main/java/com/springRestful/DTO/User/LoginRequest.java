package com.springRestful.DTO.User;

import lombok.Data;
import lombok.ToString;



@Data
@ToString
public class LoginRequest {    
    private String id;       
    private String password;
    
}

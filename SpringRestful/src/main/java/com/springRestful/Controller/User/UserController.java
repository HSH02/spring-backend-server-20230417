package com.springRestful.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springRestful.CustomTypes.CustomResponse;
import com.springRestful.DTO.User.LoginRequest;
import com.springRestful.Entity.User.Users;
import com.springRestful.Service.User.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	
    @Autowired
    private UserService userService;
    
    @GetMapping("/search")
    public List<Users> getUsers() {
        return userService.findUsers();
    }
    
    @PostMapping("/signup")
    public ResponseEntity<CustomResponse> signup(@RequestBody Users user){    	    
    	
    	CustomResponse response = userService.createUser(user);
    	
    	if(response.isSuccess()) {
    		return ResponseEntity.ok(response);
    	}else {
    		return ResponseEntity.badRequest().body(response);
    	}    	    
    }
    
    @PostMapping("/login")
    public ResponseEntity<CustomResponse> login(@RequestBody LoginRequest loginRequest){
    	CustomResponse response = userService.login(loginRequest);
    	
    	if(response.isSuccess()) {
    		HttpHeaders headers  = new HttpHeaders();
    		headers.set("Authorization", "Bearer " + response.getMessage());
    	    return ResponseEntity.ok().headers(headers).body(response);
    	}else {
    		return ResponseEntity.badRequest().body(response);
    	} 
    }
}    
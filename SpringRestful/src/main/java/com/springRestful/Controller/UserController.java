package com.springRestful.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springRestful.Entity.Users;
import com.springRestful.Service.UserService;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class UserController {
	
    @Autowired
    private UserService userService;
    
    @GetMapping("/allUsers")
    public List<Users> getUsers() {
        return userService.getUsers();
    }
    
}    

	@Configuration
	class WebConfig implements WebMvcConfigurer {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
			.allowedOrigins("http://localhost:3000");
		}
	}
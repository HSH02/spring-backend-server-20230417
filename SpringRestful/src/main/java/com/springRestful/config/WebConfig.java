package com.springRestful.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		 registry.addMapping("/**")
         .allowedOrigins("http://localhost:3000") // 프론트엔드 애플리케이션의 주소를 허용
         .allowedMethods("*")
         .allowedHeaders("*")
         .allowCredentials(true);
	}
}

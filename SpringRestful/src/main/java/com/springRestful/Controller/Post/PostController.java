package com.springRestful.Controller.Post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springRestful.CustomTypes.CustomResponse;
import com.springRestful.DTO.Post.GetPostCreateRequest;
import com.springRestful.Entity.Post.Posts;
import com.springRestful.Service.Post.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired 
	private PostService postService;
	
	
	@PostMapping("/create")
	public ResponseEntity<CustomResponse> createPost(@RequestBody GetPostCreateRequest postCreateRequest){
		postService.createPost(postCreateRequest);
				
		CustomResponse response = postService.createPost(postCreateRequest);
		
		if(response.isSuccess()) {
			return ResponseEntity.ok(response);
		}else {
			return ResponseEntity.badRequest().body(response);
		}		
	}
	
	@GetMapping("/search")
	public List<Posts> getPosts(){
		return postService.getPosts();
	}
	
//	@GetMapping("/update")
//	public List<Posts> getPosts(){
//		return postService.getPosts();
//	}
//	
//	@GetMapping("/delete")
//	public List<Posts> getPosts(){
//		return postService.getPosts();
//	}
}

package com.springRestful.DAO.Post;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.springRestful.DTO.Post.PostCreateCategory;
import com.springRestful.DTO.Post.PostCreateCategoryMap;
import com.springRestful.DTO.Post.PostCreateInfo;
import com.springRestful.Entity.Post.Posts;

@Mapper
public interface PostDAO {
    List<Posts> findPost();

	int createPost(PostCreateInfo postCreateInfo);

	int createCategory(PostCreateCategory postCreateCategory);

	void createPostCategoryMap(PostCreateCategoryMap postCreateCategoryMap);

	int getCategoryId(String categoryName);

	Integer createCategoryIfNotExists(PostCreateCategory postCreateCategory);
}



package com.springRestful.DAO.User;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.springRestful.CustomTypes.UserSearchKeyword;
import com.springRestful.Entity.User.Users;

@Mapper
public interface UserDAO {
     
	List<Users> findUserCommonInfo(UserSearchKeyword searchKeyword);
	Users findUserLoginInfoByID(UserSearchKeyword searchKeyword);
	
	Boolean findUserIdExist(UserSearchKeyword searchKeyword);
	
	void createUser(Users user);
		
}



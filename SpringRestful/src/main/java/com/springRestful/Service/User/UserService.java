package com.springRestful.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springRestful.CustomTypes.CustomResponse;
import com.springRestful.CustomTypes.JwtUtil;
import com.springRestful.CustomTypes.UserSearchKeyword;
import com.springRestful.DAO.User.UserDAO;
import com.springRestful.DTO.User.LoginRequest;
import com.springRestful.Entity.User.Users;

import java.util.List;
import java.util.regex.*;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    
    Pattern USER_ID_PATTERN = createPattern("^[a-zA-Z0-9]+$");
    Pattern USER_NAME_PATTERN = createPattern("^[\\uac00-\\ud7a3a-zA-Z0-9]+$");
	Pattern PASSWORD_PATTERN = createPattern("^[a-zA-Z0-9!@#$%^&*()]+$");
	Pattern EMAIL_PATTERN = createPattern("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    
    public List<Users>findUsers() {
    	UserSearchKeyword searchKeyword = createEmptySearchKeyword(); 
        return userDAO.findUserCommonInfo(searchKeyword);
    }
        
	public CustomResponse createUser(Users user) {				
		String name = user.getUserName();
		String id = user.getUserId();
		String email = user.getUserEmail();
		String password = user.getUserPassword();
		
		UserSearchKeyword searchKeyword = createEmptySearchKeyword();
		searchKeyword.setUserIdKeyWord(id);
		Boolean findUserIdExist = userDAO.findUserIdExist(searchKeyword);
				
		
		if (!isValidLength(name, 1, 10) || !isValidPattern(USER_NAME_PATTERN, name)) {
			return new CustomResponse(false, "이름 길이 또는 이름 구성이 올바르지 않습니다.");
	    }

        if (!isValidLength(id, 4, 15)   || !isValidPattern(USER_ID_PATTERN, id) ){
        	return new CustomResponse(false, "ID 길이 또는 이름 구성이 올바르지 않습니다.");
        }
        
        if (findUserIdExist) {
        	return new CustomResponse(false, "이미 같은 ID가 존재합니다.");
        }
        
        if (!isValidLength(email, 6, 50) || !isValidPattern(EMAIL_PATTERN, email)) {
             return new CustomResponse(false, "이메일 길이 또는 이름 구성이 올바르지 않습니다.");
        }
        
        if (!isValidLength(password, 6, 20) || !isValidPattern(PASSWORD_PATTERN, password)) {
             return new CustomResponse(false, "Password 길이 또는 이름 구성이 올바르지 않습니다.");
        }
		
		user.setUserRole("user");
		user.setUuid(UUID.randomUUID().toString());
				
		userDAO.createUser(user);
		
		
		return new CustomResponse(true, "회원가입이 완료되었습니다");
	}
	
	public CustomResponse login(LoginRequest loginRequest) {
		String id = loginRequest.getId();
		String password = loginRequest.getPassword();
							
		Users user = findUserCredentialsById(id);
		
		if(user == null || !user.getUserPassword().equals(password)){
			 return new CustomResponse(false, "ID 또는 비밀번호가 잘못되었습니다.");
		}
					
		String token = JwtUtil.generateToken(user.getUuid(), user.getUserName(), user.getUserEmail());
		
		return new CustomResponse(true, token);
	}
		
	public Users findUserCredentialsByUuid(String uuid) {
	    UserSearchKeyword searchKeyword = createEmptySearchKeyword();
	    searchKeyword.setUserUuidKeyWord(uuid);
	    return userDAO.findUserCredentialsByIdOrUuid(searchKeyword);
	}

   
   public Users findUserCredentialsById(String id) {
   		UserSearchKeyword searchKeyword = createEmptySearchKeyword();		
		searchKeyword.setUserIdKeyWord(id);
		return userDAO.findUserCredentialsByIdOrUuid(searchKeyword);
   }
		
	private UserSearchKeyword createEmptySearchKeyword() {
		UserSearchKeyword searchKeyword = new UserSearchKeyword();
		return searchKeyword;
	}	
		
	private Pattern createPattern(String reg) {
		return Pattern.compile(reg);
	}
	
	private boolean isValidLength(String input, int min, int max) {
		return input.length() >= min && input.length() <= max;
	}
	
	private boolean isValidPattern(Pattern pattern, String input) {
		return pattern.matcher(input).matches();
	}
	
}


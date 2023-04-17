package com.springRestful.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springRestful.DAO.UserDAO;
import com.springRestful.Entity.Users;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    
    public List<Users> getUsers() {
        return userDAO.selectAllData();
    }
}

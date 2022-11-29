package com.aditya.User_Authentication_Service.service;

import com.aditya.User_Authentication_Service.domain.User;

import java.util.List;


public interface UserService {
	User saveUser(User user);
	List<User> getAllUser();
	User getByUserId(int id);
	User findByUserNameAndPassword(String username, String password);

}

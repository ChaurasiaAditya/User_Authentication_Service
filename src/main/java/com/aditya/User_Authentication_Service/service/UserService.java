package com.aditya.User_Authentication_Service.service;

import com.aditya.User_Authentication_Service.domain.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
	User saveUser(User user);
	List<User> getAllUser();
	Optional<User> getByUserId(int id);
	User findByUserNameAndPassword(String username, String password);

}

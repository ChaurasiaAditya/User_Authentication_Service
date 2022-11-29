/*
 * Author Name: Aditya Chaurasia
 * Date: 29-11-2022
 * Created With: IntelliJ IDEA Ultimate
 * Profile: github.com/ChaurasiaAditya
 * Website: ChaurasiaAditya.in
 */
package com.aditya.User_Authentication_Service.service;

import com.aditya.User_Authentication_Service.domain.User;
import com.aditya.User_Authentication_Service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return null;
	}

	@Override
	public List<User> getAllUser() {
		return null;
	}

	@Override
	public User getByUserId(int id) {
		return null;
	}

	@Override
	public User findByUserNameAndPassword(String username, String password) {
		return null;
	}
}

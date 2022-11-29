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
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return this.userRepository.findAll();
	}

	@Override
	public Optional<User> getByUserId(int id) {
		return this.userRepository.findById(id);
	}

	@Override
	public User findByUserNameAndPassword(String username, String password) {
		return this.userRepository.findByUserNameAndPassword(username,password);
	}
}

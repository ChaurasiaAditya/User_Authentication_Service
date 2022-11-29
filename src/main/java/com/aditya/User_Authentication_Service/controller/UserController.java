/*
 * Author Name: Aditya Chaurasia
 * Date: 29-11-2022
 * Created With: IntelliJ IDEA Ultimate
 * Profile: github.com/ChaurasiaAditya
 * Website: ChaurasiaAditya.in
 */
package com.aditya.User_Authentication_Service.controller;

import com.aditya.User_Authentication_Service.domain.User;
import com.aditya.User_Authentication_Service.exception.UserNotFoundException;
import com.aditya.User_Authentication_Service.service.SecurityTokenGeneratorImpl;
import com.aditya.User_Authentication_Service.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class UserController {

	private final UserServiceImpl userService;
	private final SecurityTokenGeneratorImpl securityTokenGenerator;

	@Autowired
	public UserController(UserServiceImpl userService, SecurityTokenGeneratorImpl securityTokenGenerator) {
		this.userService = userService;
		this.securityTokenGenerator = securityTokenGenerator;
	}

	@PostMapping("add")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		return new ResponseEntity<>(this.userService.saveUser(user), HttpStatus.CREATED);
	}

	@GetMapping("api/v1/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.userService.getAllUser());
	}

	@GetMapping("api/v1/getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		return ResponseEntity.ok(this.userService.getByUserId(id));
	}

	@DeleteMapping("api/v1/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id) {
		return new ResponseEntity<>(this.userService.deleteUserById(id), HttpStatus.OK);
	}

	@GetMapping("login")
	public ResponseEntity<?> getByLogin(@RequestBody User user) throws UserNotFoundException {
		try {
			this.userService.loginCheck(user.getUserName(), user.getPassword());
			Map<String, String> secretKey = this.securityTokenGenerator.generateToken(user);
			return new ResponseEntity<>(secretKey, HttpStatus.OK);
		} catch (UserNotFoundException exception) {
			throw new UserNotFoundException();
		} catch (Exception exception) {
			return new ResponseEntity<>("Network Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

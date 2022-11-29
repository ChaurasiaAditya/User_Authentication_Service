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
import com.aditya.User_Authentication_Service.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class UserController {

	private final UserServiceImpl userService;

	@Autowired
	public UserController(UserServiceImpl userService) {
		this.userService = userService;
	}

	@PostMapping("add")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		return new ResponseEntity<>(this.userService.saveUser(user), HttpStatus.CREATED);
	}

	@GetMapping("getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.userService.getAllUser());
	}

	@GetMapping("getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		return ResponseEntity.ok(this.userService.getByUserId(id));
	}

	@GetMapping("login")
	public ResponseEntity<?> getByLogin(@RequestBody User user) throws UserNotFoundException {
		try {
			this.userService.loginCheck(user.getUserName(), user.getPassword());
			return new ResponseEntity<>("Login Success", HttpStatus.OK);
		} catch (UserNotFoundException exception) {
			throw new UserNotFoundException();
		} catch (Exception exception) {
			return new ResponseEntity<>("Network Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

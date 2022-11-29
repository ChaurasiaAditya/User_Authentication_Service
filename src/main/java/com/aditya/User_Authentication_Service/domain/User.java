/*
 * Author Name: Aditya Chaurasia
 * Date: 29-11-2022
 * Created With: IntelliJ IDEA Ultimate
 * Profile: github.com/ChaurasiaAditya
 * Website: ChaurasiaAditya.in
 */
package com.aditya.User_Authentication_Service.domain;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String mobile;

	public User() {
	}

	public User(int id, String firstName, String lastName, String userName, String password, String mobile) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.mobile = mobile;
	}
}

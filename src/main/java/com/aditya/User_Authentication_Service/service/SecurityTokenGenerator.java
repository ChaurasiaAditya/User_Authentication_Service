package com.aditya.User_Authentication_Service.service;

import com.aditya.User_Authentication_Service.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {

	Map<String,String> generateToken(User user);
}

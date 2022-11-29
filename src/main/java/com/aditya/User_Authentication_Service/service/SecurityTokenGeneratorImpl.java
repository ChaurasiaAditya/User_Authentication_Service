/*
 * Author Name: Aditya Chaurasia
 * Date: 29-11-2022
 * Created With: IntelliJ IDEA Ultimate
 * Profile: github.com/ChaurasiaAditya
 * Website: ChaurasiaAditya.in
 */
package com.aditya.User_Authentication_Service.service;

import com.aditya.User_Authentication_Service.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator {
	@Override
	public Map<String, String> generateToken(User user) {
		String jwtToken;
		jwtToken = Jwts.builder().setSubject(user.getUserName()) // Header
			.setIssuedAt(new Date()) // Payload
			.signWith(SignatureAlgorithm.HS256, "secretkey.") // Verify Signature
			.compact();

		Map<String, String> map = new HashMap<>();
		map.put("token", jwtToken);
		map.put("message", "User Successfully logged in");
		return map;
	}
}

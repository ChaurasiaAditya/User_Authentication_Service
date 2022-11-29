/*
 * Author Name: Aditya Chaurasia
 * Date: 29-11-2022
 * Created With: IntelliJ IDEA Ultimate
 * Profile: github.com/ChaurasiaAditya
 * Website: ChaurasiaAditya.in
 */
package com.aditya.User_Authentication_Service.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpServletResponse response = (HttpServletResponse) servletResponse;
		final String authHeader = request.getHeader("authorization");
		if ("OPTIONS".equals(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
			filterChain.doFilter(request, response);
		} else {
			if (authHeader == null || !authHeader.startsWith("Bearer ")) {
				throw new ServletException("Missing or invalid Authorization header");
			}
			final String token = authHeader.substring(7);
			final Claims claims = Jwts.parser().setSigningKey("secretKey").parseClaimsJws(token).getBody();
			request.setAttribute("claims", claims);
			filterChain.doFilter(request, response);
		}
	}
}

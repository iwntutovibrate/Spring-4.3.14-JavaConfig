package com.example.javaconfig.common.security;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class AuthenticationFail extends AbstractAuthenticationTargetUrlRequestHandler implements AuthenticationFailureHandler {
	
	private String failUrl = "/example/security/login";
	
	public AuthenticationFail() {}
	
	public AuthenticationFail(String failUrl) {
		this.failUrl = failUrl;
	}
	
	@SuppressWarnings("all") private static final Logger logger = LoggerFactory.getLogger(AuthenticationFail.class);
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exeption) throws IOException, ServletException {
		
		Enumeration<String> enumeration = request.getAttributeNames();
		while (enumeration.hasMoreElements()) {
			String name = (String) enumeration.nextElement();
			logger.error("name : {} ===> value : {}", name, request.getParameter(name));
		}
		getRedirectStrategy().sendRedirect(request, response, this.failUrl );
	}

}

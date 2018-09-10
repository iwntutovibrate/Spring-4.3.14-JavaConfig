package com.example.javaconfig.common.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.javaconfig.main.dto.UserDTO;
import com.example.javaconfig.main.service.UserService;


public class UserDetailService implements UserDetailsService {

	@SuppressWarnings("all")
	private static final Logger logger = LoggerFactory.getLogger(UserDetailService.class);
	
	
	@Autowired private UserService userService = null;

	
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		UserDTO userDTO = null;
		try{
			userDTO = userService.getUserByLoginId(loginId);
			
			if( userDTO == null ) {
				throw new BadCredentialsException("The username or password do not match.");
			}
		}catch(DataAccessException dae){
			dae.printStackTrace();
			logger.error("[ERROR]==>", dae);
			throw new DataAccessException("ERROR") {
				private static final long serialVersionUID = 1L;
			};
		}
		
		return new UserDetail(userDTO);
	}
	
}

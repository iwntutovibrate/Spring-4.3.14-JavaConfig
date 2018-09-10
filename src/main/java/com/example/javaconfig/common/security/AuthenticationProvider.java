package com.example.javaconfig.common.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SuppressWarnings("all")
public class AuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	
	@SuppressWarnings("all")
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationProvider.class);
	
	@Autowired
	private UserDetailsService userDetailsService = null;

	/**
	 * @function : (Spring Security) User Login Password Compare
	 * @param    : UserDetails userDetails, UsernamePasswordAuthenticationToken authentication
	 * @author   : iwntutovibrate
	 * @date     : 2018. 09. 10.
	 */
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

		String password = authentication.getCredentials().toString();
		
		if (password.length() == 64) {
			password = authentication.getCredentials().toString();
		} else {
			password = PasswordEncryption.encryptConvert(password);
		}

		if (!password.equals(userDetails.getPassword())) {
			throw new AuthenticationServiceException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badPassword", "no available!!"));
		}
	}

	/**
	 * @function : Checking if User Login ID exists in databases
	 * @param    : String username, UsernamePasswordAuthenticationToken arg1
	 * @author   : iwntutovibrate
	 * @date     : 2018. 09. 10.
	 * @return   : UserDetails
	 */
	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken arg1) throws AuthenticationException {

		UserDetails loadedUser = null;
		
		try {
			loadedUser = userDetailsService.loadUserByUsername(username);
		} catch (UsernameNotFoundException notFound) {
			throw notFound;
		} catch (Exception repositoryProblem) {
			throw new AuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
		}

		if (loadedUser == null) {
			throw new AuthenticationServiceException("UserDetailsService returned null, which is an interface contract violation");
		}
		
		return loadedUser;
	}
}
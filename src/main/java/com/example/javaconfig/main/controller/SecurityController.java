package com.example.javaconfig.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {

	@SuppressWarnings("all")
	private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);
	
	/**
	 * @request    : example/security
	 * @response   : example/security
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 10.
	 */
	@RequestMapping(value="example/security/index", method=RequestMethod.GET)
	public void securityIndex() {
		
	}

	@RequestMapping(value="example/security/register", method=RequestMethod.GET)
	public void securityRegister() {
		
	}

	@RequestMapping(value="example/security/login", method=RequestMethod.GET)
	public void securityLogin() {
		
	}

	@Secured("ROLE_USER")
	@RequestMapping(value="example/security/success", method=RequestMethod.GET)
	public void securitySuccess() {
		
	}
}

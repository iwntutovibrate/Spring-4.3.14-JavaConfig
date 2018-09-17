package com.example.javaconfig.main.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.javaconfig.main.dto.UserDTO;
import com.example.javaconfig.main.service.UserService;

@Controller
public class SecurityController {

	@SuppressWarnings("all")
	private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);
	
	@Autowired private UserService userService = null;
	
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

	@ResponseBody
	@RequestMapping(value="example/security/register", method=RequestMethod.POST)
	public String Register(UserDTO userDTO) {
		userService.register(userDTO);
		return "Success";
	}

	@RequestMapping(value="example/security/login", method=RequestMethod.GET)
	public void securityLogin(HttpServletRequest request) {
		
		Enumeration<String> enumeration = request.getAttributeNames();
		while (enumeration.hasMoreElements()) {
			String name = (String) enumeration.nextElement();
			logger.info("name : {} ===> value : {}", name, request.getParameter(name));
		}
	}

	@Secured("ROLE_USER")
	@RequestMapping(value="example/security/success", method=RequestMethod.GET)
	public void securitySuccess() {
		
	}
}

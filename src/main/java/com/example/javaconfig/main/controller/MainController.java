package com.example.javaconfig.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.javaconfig.main.dto.UserDTO;
import com.example.javaconfig.main.service.UserService;

@Controller
public class MainController {

	@SuppressWarnings("all")
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);


	@Autowired private UserService userService = null;


	/**
	 * @request    : pageContext.request.contextPath
	 * @response   : main/index.jsp
	 * @author     : iwntutovibrate
	 * @date       : 2018. 08. 07.
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mainIndex() {
		
		return "main/index";
	}

}

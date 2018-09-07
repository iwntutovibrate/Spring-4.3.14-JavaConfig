package com.example.javaconfig.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DataBaseController {

	@SuppressWarnings("all")
	private static final Logger logger = LoggerFactory.getLogger(DataBaseController.class);

	/**
	 * @request    : example/database
	 * @response   : example/database
	 * @author     : iwntutovibrate
	 * @date       : 2018. 08. 07.
	 */
	@RequestMapping(value="example/database", method=RequestMethod.GET)
	public void dataBasePage() {
		
	}
}

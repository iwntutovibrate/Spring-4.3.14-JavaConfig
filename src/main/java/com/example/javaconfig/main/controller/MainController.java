package com.example.javaconfig.main.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {

	@SuppressWarnings("all")
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	/**
	 * @request    : pageContext.request.contextPath
	 * @response   : main/index.jsp
	 * @author     : iwntutovibrate
	 * @date       : 2018. 08. 07.
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mainIndex() {
		
		logger.debug("=============== LogBack TEST ===============");
		return "main/index";
	}

}

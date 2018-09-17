package com.example.javaconfig.main.controller;


import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;


@Controller
public class MainController {

	@SuppressWarnings("all")
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	final List<DeferredResult<String>> list = new LinkedList<>();
	
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
	
	@RequestMapping("/async")
	@ResponseBody
	public DeferredResult<String> async() {
		final DeferredResult<String> result = new DeferredResult<>();
		list.add(result);
		return result;
	}

	@RequestMapping("/event")
	@ResponseBody
	public String event(String msg) {
	for(DeferredResult<String> result : list) {
		result.setResult(msg);
	}
		return "OK";
	}
	
}

package com.example.javaconfig.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.javaconfig.main.dto.ExampleDTO;
import com.example.javaconfig.main.service.ExampleService;

@Controller
public class DataBaseController {

	@SuppressWarnings("all")
	private static final Logger logger = LoggerFactory.getLogger(DataBaseController.class);

	@Autowired private ExampleService exampleService = null;
	
	/**
	 * @request    : example/database
	 * @response   : example/database
	 * @param      : Model
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 07.
	 */
	@RequestMapping(value="example/database", method=RequestMethod.GET)
	public void select(Model model) {
		model.addAttribute("exampleList", exampleService.getAllExampleDataList());
	}



	/**
	 * @request    : example/database/insert
	 * @response   : example/database
	 * @param      : ExampleDTO
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 10.
	 */
	@RequestMapping(value="example/database/insert", method=RequestMethod.POST)
	public String insert(ExampleDTO exampleDTO) {
		
		exampleService.setExample(exampleDTO);
		return "redirect:/example/database";
	}



	/**
	 * @request    : example/database/update
	 * @response   : example/database
	 * @param      : ExampleDTO
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 10.
	 */
	@RequestMapping(value="example/database/update", method=RequestMethod.POST)
	public String update(ExampleDTO exampleDTO) {
		
		exampleService.editExampleName(exampleDTO);
		return "redirect:/example/database";
	}



	/**
	 * @request    : example/database/delete
	 * @response   : example/database
	 * @param      : int 
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 10.
	 */
	@RequestMapping(value="example/database/delete", method=RequestMethod.POST)
	public String delete(int idx) {
		
		exampleService.removeExample(idx);
		return "redirect:/example/database";
	}



}

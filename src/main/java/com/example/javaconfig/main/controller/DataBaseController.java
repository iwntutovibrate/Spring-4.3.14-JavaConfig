package com.example.javaconfig.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.javaconfig.main.dto.UserDTO;
import com.example.javaconfig.main.service.UserService;

@Controller
public class DataBaseController {

	@SuppressWarnings("all")
	private static final Logger logger = LoggerFactory.getLogger(DataBaseController.class);

	@Autowired private UserService userService = null;
	
	/**
	 * @request    : example/database
	 * @response   : example/database
	 * @param      : Model
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 07.
	 */
	@RequestMapping(value="example/database", method=RequestMethod.GET)
	public void select(Model model) {
		model.addAttribute("userList", userService.getAllUserDataList());
	}



	/**
	 * @request    : example/database/insert
	 * @response   : example/database
	 * @param      : UserDTO
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 10.
	 */
	@RequestMapping(value="example/database/insert", method=RequestMethod.POST)
	public String insert(UserDTO userDTO) {
		
		userService.setUser(userDTO);
		return "redirect:/example/database";
	}



	/**
	 * @request    : example/database/update
	 * @response   : example/database
	 * @param      : UserDTO
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 10.
	 */
	@RequestMapping(value="example/database/update", method=RequestMethod.POST)
	public String update(UserDTO userDTO) {
		
		userService.editUserName(userDTO);
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
		
		userService.removeUser(idx);
		return "redirect:/example/database";
	}



}

package com.example.javaconfig.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javaconfig.main.dao.UserDAO;
import com.example.javaconfig.main.dto.UserDTO;

@Service
public class UserService {

	@Autowired private UserDAO userDAO = null;
	
	public List<UserDTO> getAllUserDataList(){
		
		 // Business logic here...
				
		return userDAO.selectAllUser();
	}
}

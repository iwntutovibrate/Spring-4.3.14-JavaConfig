package com.example.javaconfig.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javaconfig.main.dao.UserDAO;
import com.example.javaconfig.main.dto.UserDTO;

@Service
public class UserService {

	@Autowired private UserDAO userDAO = null;
	
	public void setUser(UserDTO userDTO) {
		userDAO.insertUser(userDTO);
	}
	
	public List<UserDTO> getAllUserDataList(){
		return userDAO.selectAllUser();
	}
	
	public void editUserName(UserDTO userDTO) {
		userDAO.updateUserName(userDTO);
	}
	
	public void removeUser(int idx) {
		userDAO.deleteUser(idx);
	}
	
}

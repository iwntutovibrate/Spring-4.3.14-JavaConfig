package com.example.javaconfig.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javaconfig.main.dao.UserDAO;
import com.example.javaconfig.main.dto.UserDTO;

@Service
public class UserService {

	@Autowired private UserDAO userDAO = null;
	
	
	
	/**
	 * @Function   : Insert User Data
	 * @param      : UserDTO
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 10
	 */
	public void setUser(UserDTO userDTO) {
		userDAO.insertUser(userDTO);
	}
	
	
	
	/**
	 * @Function   : Select All User Data
	 * @return     : List<UserDTO>
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 10
	 */
	public List<UserDTO> getAllUserDataList(){
		return userDAO.selectAllUser();
	}
	
	
	
	/**
	 * @Function   : Update User Name
	 * @param      : UserDTO
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 10
	 */
	public void editUserName(UserDTO userDTO) {
		userDAO.updateUserName(userDTO);
	}
	
	
	
	/**
	 * @Function   : Delete User Data
	 * @param      : int 
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 10
	 */
	public void removeUser(int idx) {
		userDAO.deleteUser(idx);
	}
	
}

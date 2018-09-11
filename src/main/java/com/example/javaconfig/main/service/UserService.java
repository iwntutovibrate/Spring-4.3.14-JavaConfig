package com.example.javaconfig.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javaconfig.common.security.PasswordEncryption;
import com.example.javaconfig.main.dao.UserDAO;
import com.example.javaconfig.main.dto.UserDTO;

@Service
public class UserService {

	@Autowired private UserDAO userDAO = null;
	
	
	
	/**
	 * @Function   : Select User By Login ID
	 * @param      : UserDTO
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 10
	 */
	public UserDTO getUserByLoginId(String loginId) {
		return userDAO.selectUserByLoginId(loginId);
	}
	
	
	
	/**
	 * @Function   : Register
	 * @param      : UserDTO
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 11
	 */
	public void register(UserDTO userDTO) {
		
		String password = PasswordEncryption.encryptConvert(userDTO.getLoginPw());
		userDTO.setLoginPw(password);
		userDAO.insertUser(userDTO);
	}

}

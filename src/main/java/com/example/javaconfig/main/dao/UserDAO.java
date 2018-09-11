package com.example.javaconfig.main.dao;


import org.springframework.stereotype.Repository;

import com.example.javaconfig.common.dao.BaseDaoSupport;
import com.example.javaconfig.main.dto.UserDTO;

@Repository
public class UserDAO extends BaseDaoSupport{

	public UserDTO selectUserByLoginId(String loginId) {
		return this.getSqlSession().selectOne("User.selectUserByLoginId", loginId);
	}
	
	public void insertUser(UserDTO userDTO) {
		this.getSqlSession().insert("User.insertUser", userDTO);
	}
}

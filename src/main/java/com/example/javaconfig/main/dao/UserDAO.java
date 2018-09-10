package com.example.javaconfig.main.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.javaconfig.common.dao.BaseDaoSupport;
import com.example.javaconfig.main.dto.UserDTO;

@Repository
public class UserDAO extends BaseDaoSupport{

	public void insertUser(UserDTO userDTO) {
		this.getSqlSession().insert("User.insertUser", userDTO);
	}
	
	public List<UserDTO> selectAllUser() {
		return this.getSqlSession().selectList("User.selectAllUser");
	}
	
	public void updateUserName(UserDTO userDTO) {
		this.getSqlSession().update("User.updateUserName", userDTO);
	}
	
	public void deleteUser(int idx) {
		this.getSqlSession().delete("User.deleteUser", idx);
	}
}

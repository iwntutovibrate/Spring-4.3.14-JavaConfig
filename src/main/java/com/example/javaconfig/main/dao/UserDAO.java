package com.example.javaconfig.main.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.javaconfig.common.dao.BaseDaoSupport;
import com.example.javaconfig.main.dto.UserDTO;

@Repository
public class UserDAO extends BaseDaoSupport{

	public List<UserDTO> selectAllUser() {
		return this.getSqlSession().selectList("selectAllUser");
	}
}

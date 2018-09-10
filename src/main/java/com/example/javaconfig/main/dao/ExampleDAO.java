package com.example.javaconfig.main.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.javaconfig.common.dao.BaseDaoSupport;
import com.example.javaconfig.main.dto.ExampleDTO;

@Repository
public class ExampleDAO extends BaseDaoSupport{

	public void insertExample(ExampleDTO exampleDTO) {
		this.getSqlSession().insert("Example.insertExample", exampleDTO);
	}
	
	public List<ExampleDTO> selectAllExample() {
		return this.getSqlSession().selectList("Example.selectAllExample");
	}
	
	public void updateExampleName(ExampleDTO exampleDTO) {
		this.getSqlSession().update("Example.updateExampleName", exampleDTO);
	}
	
	public void deleteExample(int idx) {
		this.getSqlSession().delete("Example.deleteExample", idx);
	}
}

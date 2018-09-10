package com.example.javaconfig.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javaconfig.main.dao.ExampleDAO;
import com.example.javaconfig.main.dto.ExampleDTO;

@Service
public class ExampleService {

	@Autowired private ExampleDAO exampleDAO = null;
	
	
	
	/**
	 * @Function   : Insert Example Data
	 * @param      : ExampleDTO
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 10
	 */
	public void setExample(ExampleDTO exampleDTO) {
		exampleDAO.insertExample(exampleDTO);
	}
	
	
	
	/**
	 * @Function   : Select All Example Data
	 * @return     : List<ExampleDTO>
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 10
	 */
	public List<ExampleDTO> getAllExampleDataList(){
		return exampleDAO.selectAllExample();
	}
	
	
	
	/**
	 * @Function   : Update Example Name
	 * @param      : ExampleDTO
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 10
	 */
	public void editExampleName(ExampleDTO exampleDTO) {
		exampleDAO.updateExampleName(exampleDTO);
	}
	
	
	
	/**
	 * @Function   : Delete Example Data
	 * @param      : int 
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 10
	 */
	public void removeExample(int idx) {
		exampleDAO.deleteExample(idx);
	}
	
}

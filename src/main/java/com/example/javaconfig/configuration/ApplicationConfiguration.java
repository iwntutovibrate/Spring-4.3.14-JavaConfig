package com.example.javaconfig.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@PropertySource("classpath:database.properties")
@ComponentScan(basePackages = "com.example.javaconfig",
			   excludeFilters = {
					   @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Controller.class)
			   },
			   includeFilters = {
					   @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Service.class),
					   @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Repository.class),
					   @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Component.class),
					   @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Autowired.class)
			   })
@Import({
		  DataBaseConfiguration.class
		, SpringSecurityConfiguration.class
		})
public class ApplicationConfiguration {
	
	@SuppressWarnings("all")
	private static final Logger logger = LoggerFactory.getLogger(ApplicationConfiguration.class);
	
	
}

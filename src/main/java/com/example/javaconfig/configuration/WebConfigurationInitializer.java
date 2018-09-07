package com.example.javaconfig.configuration;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfigurationInitializer implements WebApplicationInitializer {
	
	@SuppressWarnings("all")
	private static final Logger logger = LoggerFactory.getLogger(WebConfigurationInitializer.class);
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext applicationConfiguration = new AnnotationConfigWebApplicationContext();
		applicationConfiguration.register(ApplicationConfiguration.class);
		
		ContextLoaderListener listener = new ContextLoaderListener(applicationConfiguration);
		servletContext.addListener(listener);

		AnnotationConfigWebApplicationContext servletConfiguration = new AnnotationConfigWebApplicationContext();
		servletConfiguration.register(ServletConfiguration.class);
		servletConfiguration.setServletContext(servletContext);

		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",
				new DispatcherServlet(servletConfiguration));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");

		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		
		FilterRegistration.Dynamic characterEncoding = servletContext.addFilter("characterEncodingFilter",
				characterEncodingFilter);
		
		characterEncoding.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
	}

}

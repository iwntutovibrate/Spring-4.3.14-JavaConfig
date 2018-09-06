package com.example.javaconfig.configuration;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfigurationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		// ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
		// servletContext.addListener(listener);

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

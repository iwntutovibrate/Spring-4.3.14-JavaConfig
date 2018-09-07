package com.example.javaconfig.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.javaconfig",
			   includeFilters = {
					@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Controller.class)
			   },
			   excludeFilters = {
					@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Service.class),
					@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Repository.class),
					@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Component.class),
					@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Autowired.class)
			   })

public class ServletConfiguration extends WebMvcConfigurerAdapter{

	@SuppressWarnings("all")
	private static final Logger logger = LoggerFactory.getLogger(ServletConfiguration.class);
	
	
	/**
	 * @Function   : View Resource Handlers
	 * @param      : ResourceHandlerRegistry
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 06
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/res/**").addResourceLocations("/resources/");
	}
	
	
	
	/**
	 * @Function   : Content Negotiating View Resolver
	 * @param      : ContentNegotiationManager
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 06.
	 * @return     : ViewResolver - List<ViewResolver>
	 */
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(manager);

		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

		resolvers.add(jspViewResolver());
		resolvers.add(jsonViewResolver());
		return resolver;
	}
	
	
	
	/**
	 * @Function   : JSP View Resolver
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 06.
	 * @return     : ViewResolver
	 */
	@Bean
	public ViewResolver jspViewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setContentType("text/html");
		viewResolver.setOrder(2);
		
		return viewResolver;
	}
	
	
	
	/**
	 * @Function   : JSON View Resolver
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 06.
	 * @return     : ViewResolver
	 */
	@Bean
	public ViewResolver jsonViewResolver() {
		return new ViewResolver() {
			
			@Override
			public View resolveViewName(String arg0, Locale arg1) throws Exception {
				MappingJackson2JsonView view = new MappingJackson2JsonView();
				view.setPrettyPrint(true);
				return view;
			}
		};
	}
	
	
	
	/**
	 * @Function   : PropertyPlaceholderConfigurer
	 * @author     : iwntutovibrate
	 * @date       : 2018. 09. 07.
	 * @return     : classpath:database.properties
	 */
	@Bean
	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {

		PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
		propertyPlaceholderConfigurer.setLocation(new ClassPathResource("database.properties"));

		return propertyPlaceholderConfigurer;
	}
	
}

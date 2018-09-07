package com.example.javaconfig.configuration;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class DataBaseConfiguration {

	
	@SuppressWarnings("all")
	private static final Logger logger = LoggerFactory.getLogger(DataBaseConfiguration.class);
	
	
	@Value("${database.driverClassName}")
	private String driverClassName = null;

	@Value("${database.url}")
	private String url = null;
	
	@Value("${database.username}")
	private String username = null;
	
	@Value("${database.password}")
	private String password = null;
	
	
	@Autowired ApplicationContext applicationContext = null;
	
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.driverClassName);
		dataSource.setUrl(this.url);
		dataSource.setUsername(this.username);
		dataSource.setPassword(this.password);
		return dataSource;
	}
	
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource,
	ApplicationContext applicationContext) throws IOException {

		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
		factoryBean.setMapperLocations(applicationContext.getResources("classpath*:/**/maps/*.xml"));
		
		return factoryBean;
	}
	
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}

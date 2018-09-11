package com.example.javaconfig.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.javaconfig.common.security.AuthenticationProvider;
import com.example.javaconfig.common.security.AuthenticationSuccess;
import com.example.javaconfig.common.security.UserDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/res/**"); // #3
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.sessionManagement()
				.maximumSessions(1)
				.maxSessionsPreventsLogin(true)
				.expiredUrl("/example/security/login");
		
		http.csrf().disable().httpBasic()
			.and()
			.authorizeRequests()
				.antMatchers("/**").permitAll()
				.antMatchers("/example/database/**").permitAll()
				.antMatchers("/example/security/success").access("hasRole('ROLE_USER')")
			.and()
			.formLogin()
				.loginPage("/example/security/login")
				.loginProcessingUrl("/security/login")
				.usernameParameter("loginId")
				.passwordParameter("loginPw")
				.defaultSuccessUrl("/example/security/success")
				.failureUrl("/example/security/login?error=1")
				.successHandler(new AuthenticationSuccess())
				//.failureHandler(authenticationFail)
			.and()
			.logout()
				.logoutUrl("/security/logout")
				.logoutSuccessUrl("/example/security/index");
	}
	
	@Bean
	public UserDetailService userDetailService() {
		UserDetailService userDetailService = new UserDetailService();
		return userDetailService;
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		AuthenticationProvider authenticationProvider = new AuthenticationProvider();
		return authenticationProvider;
	}
	
}

package com.namNguyen03.authorizationServer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.antMatcher("/**")
			.authorizeRequests()
			.antMatchers("/oauth/callback").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/oauth").permitAll()
			.antMatchers("/accept").permitAll()
			.antMatchers("/erro").permitAll()
			.antMatchers("/get_profile").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.and()
			.httpBasic();
	}
}

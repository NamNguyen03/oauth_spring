package com.namNguyen03.resourceServer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableResourceServer
public class ResoruceServerConfig extends ResourceServerConfigurerAdapter {
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	
	
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(null);
	}

	

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf()
			.disable()
			.antMatcher("/**")
			.authorizeRequests()
			.antMatchers("/oauth/revoke_token").permitAll()
			.antMatchers("/oauth/authorize").permitAll()
			.antMatchers("/users/a").permitAll()
			.antMatchers("/users/role").permitAll()
			.anyRequest().authenticated()
			.and().formLogin()
			.loginPage("/login")
			.successHandler(authenticationSuccessHandler).permitAll()
			.failureUrl("/login-error")
			.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler())
			.and().httpBasic();
	}
	
}

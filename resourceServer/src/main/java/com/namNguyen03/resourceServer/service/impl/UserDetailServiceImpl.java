package com.namNguyen03.resourceServer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.namNguyen03.resourceServer.config.Constants;
import com.namNguyen03.resourceServer.model.AuthUserDetail;
import com.namNguyen03.resourceServer.model.User;
import com.namNguyen03.resourceServer.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder encoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(Constants.checkStart && userRepository.findAll().size()==0) {
			userRepository.save(new User("nam",encoder.encode("123"), "Nguyen Duc Nam", "ADMIN"));
			userRepository.save(new User("mike",encoder.encode("mike"), "Mike", "USER"));	
			Constants.checkStart=false;
		}
		
		User user =  userRepository.findByUsername(username);
		if(user==null) {
			new UsernameNotFoundException("Username and Password wrong!");
		}
		UserDetails userDetails = new AuthUserDetail(user);
		new AccountStatusUserDetailsChecker().check(userDetails);
	
		return userDetails;
	}
}

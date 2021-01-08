package com.namNguyen03.resouceServer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.namNguyen03.resouceServer.model.AuthUserDetail;
import com.namNguyen03.resouceServer.model.User;
import com.namNguyen03.resouceServer.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =  userRepository.findByUsername(username);
		if(user==null) {
			new UsernameNotFoundException("Username and Password wrong!");
		}
		UserDetails userDetails = new AuthUserDetail(user);
		new AccountStatusUserDetailsChecker().check(userDetails);
		return userDetails;
	}

}

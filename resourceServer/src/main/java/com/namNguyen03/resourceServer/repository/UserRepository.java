package com.namNguyen03.resourceServer.repository;

import java.util.List;

import javax.transaction.Transactional;
import com.namNguyen03.resourceServer.model.User;

public interface UserRepository {
	User findByUsername(String username);
	@Transactional
	void save(User user);
	List<User> findAll();
}

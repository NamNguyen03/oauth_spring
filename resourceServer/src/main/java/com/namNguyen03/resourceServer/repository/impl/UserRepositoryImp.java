package com.namNguyen03.resourceServer.repository.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.namNguyen03.resourceServer.config.Constants;
import com.namNguyen03.resourceServer.model.User;
import com.namNguyen03.resourceServer.repository.UserRepository;

@Repository
public class UserRepositoryImp implements UserRepository {

	@Autowired
	@PersistenceContext( unitName= Constants.JPA_UNIT_NAME)
	private EntityManager entityManager;
	

	
	@Override
	public User findByUsername(String username) {
		return entityManager.find(User.class, username);
	}

	@Override
	public void save(User user) { 
		entityManager.createNativeQuery("insert into t_user(user_username,user_password,user_fullname,user_role) values(?,?,?,?)")
			.setParameter(1, user.getUsername())
			.setParameter(2, user.getPassword())
			.setParameter(3, user.getFullname())
			.setParameter(4, user.getRole())
			.executeUpdate();
	}

	@Override
	public List<User> findAll() {
		return  entityManager.createQuery("select u from t_user u",User.class).getResultList();
	}

}

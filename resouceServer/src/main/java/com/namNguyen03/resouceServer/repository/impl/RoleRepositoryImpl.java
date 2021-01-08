package com.namNguyen03.resouceServer.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namNguyen03.resouceServer.config.Constants;
import com.namNguyen03.resouceServer.model.Role;
import com.namNguyen03.resouceServer.repository.RoleRepository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
	
	
	@Autowired
	@PersistenceContext( unitName= Constants.JPA_UNIT_NAME)
	private EntityManager entityManager;
	
	
	
	@Override
	public List<Role> findAll() {
		return  entityManager.createQuery("select r from t_role r",Role.class).getResultList();

	}

}

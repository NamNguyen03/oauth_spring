package com.namNguyen03.resouceServer.repository;

import java.util.List;

import com.namNguyen03.resouceServer.model.Role;

public interface RoleRepository {
	List<Role> findAll();

}

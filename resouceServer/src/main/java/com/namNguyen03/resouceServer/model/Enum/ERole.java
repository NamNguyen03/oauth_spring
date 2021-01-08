package com.namNguyen03.resouceServer.model.Enum;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;
public enum ERole {
	ADMIN(Sets.newHashSet(EPermission.ADMIN,EPermission.USER)),
	USER(Sets.newHashSet(EPermission.USER));
	final Set<EPermission> permissions;
	
		
	ERole(Set<EPermission> permissions){
		this.permissions = permissions;
	}

	Set<EPermission> getPermissions(){
		return permissions;
	}


	public Set<GrantedAuthority> getGrantedAuthorities(){
		Set<GrantedAuthority> grants = getPermissions()
				.stream()
				.map(permission ->new SimpleGrantedAuthority(permission.getPermission()))
				.collect(Collectors.toSet());
		grants.add(new SimpleGrantedAuthority(this.name()));
		return grants;
	}
}

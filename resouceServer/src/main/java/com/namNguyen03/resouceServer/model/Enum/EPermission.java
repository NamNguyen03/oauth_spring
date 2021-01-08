package com.namNguyen03.resouceServer.model.Enum;

public enum EPermission {
	ADMIN("admin"),
	USER("user");
	private final String permission;
	EPermission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
}

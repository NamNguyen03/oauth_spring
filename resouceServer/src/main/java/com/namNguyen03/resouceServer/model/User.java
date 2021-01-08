package com.namNguyen03.resouceServer.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "t_user")
public class User implements Serializable{
	private static final long serialVersionUID = -3294472154365009145L;
	@Id
	@Column(name = "user_username")
	private String username;
	@Column(name = "user_passord")
	private String password;
	@Column(name = "user_fullname")
	private String fullname;
	@ManyToOne()
    @JoinColumn(name="role_id",referencedColumnName = "role_id")
    private Role role;
	public User(User user) {
		this.fullname = user.getFullname();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.role = user.getRole();
	}
}

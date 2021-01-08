package com.namNguyen03.resouceServer.model;
import java.io.Serializable;

import javax.persistence.*;

import com.namNguyen03.resouceServer.model.Enum.ERole;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "t_role")
public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "role_id")
	@Id
	int id;
	@Column(name = "role_name")
	ERole name;
}

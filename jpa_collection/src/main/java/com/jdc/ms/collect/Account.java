package com.jdc.ms.collect;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 20, nullable = false)
	private String name;
	@Column(length = 20, nullable = false)
	private String loginId;
	@Column(length = 200, nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	public enum Role{
		ADMIN, TEACHER, STUDENT, OFFICE
	}
}

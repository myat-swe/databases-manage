package com.jdc.ms.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SecondaryTables;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
@Table(name = "member")
@SecondaryTables({
	
	@SecondaryTable(name = "login_info",
			indexes = @Index(columnList = "role")),
	
	
	@SecondaryTable(name = "contact_tbl",
	
			uniqueConstraints = @UniqueConstraint(columnNames = "email"))
	
})

public class Member implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(table = "login_info")
	private Role role;
	
	@Column(table = "login_info")
	private String logIn;
	@Column(table = "login_info")
	private String password;
	
	@Embedded
	private Contact contact;
	
	
	public enum Role{
		ADMIN,MEMBER,STUDENT
	}
	
}


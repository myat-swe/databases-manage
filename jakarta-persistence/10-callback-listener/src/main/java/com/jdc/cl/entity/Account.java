package com.jdc.cl.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "account")
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	private int amount;
	
	@Column(name = "create_at")
	private LocalDateTime createAt;
	
	@Column(name = "update_at")
	private LocalDateTime updateAt;

//	@PostLoad
//	private void doAfterSelect() {
//		System.out.println("==========");
//		System.out.println("Post Load called");
//		System.out.println("==========");
//	}
//	
//	@PrePersist
//	private void doBeforeInsert() {
//		createAt = LocalDateTime.now();
//		System.out.println("==========");
//		System.out.println("Pre Persist called");
//		System.out.println("==========");
//	}
//	
//	@PostPersist
//	private void doAfterInsert() {
//		System.out.println("==========");
//		System.out.println("Post Persist called");
//		System.out.println("==========");
//	}
//	
//	@PreUpdate
//	private void doBeforeUpdate() {
//		updateAt = LocalDateTime.now();
//		System.out.println("==========");
//		System.out.println("Pre Update called");
//		System.out.println("==========");
//	}
//	
//	@PostUpdate
//	private void doAfterUpdate() {
//		System.out.println("==========");
//		System.out.println("Post Update called");
//		System.out.println("==========");
//	}
//	
//	@PreRemove
//	private void doBeforeDelete() {
//		System.out.println("==========");
//		System.out.println("Pre Remove called");
//		System.out.println("==========");
//	}
//	
//	@PostRemove
//	private void doAfterDelete() {
//		System.out.println("==========");
//		System.out.println("Post Remove called");
//		System.out.println("==========");
//	}
	
}

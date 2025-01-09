 package com.jdc.cl.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account")
//@EntityListeners(value = AuditingListener.class)
public class Account extends AudititngEntity{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	private int amount;

	
//	@PostLoad
//	private void doAfterSelect() {
//		System.out.println("=======================");
//		System.out.println("Post Load Call");
//		System.out.println("=======================");
//
//	}
//	
//	@PrePersist
//	private void doBeforeInsert() {
//		createdAt = LocalDateTime.now();
//		System.out.println("=======================");
//		System.out.println("Pre Created Call");
//		System.out.println("=======================");
//	}
//	
//	@PostPersist
//	private void doAfterInsert() {
//		createdAt = LocalDateTime.now();
//		System.out.println("=======================");
//		System.out.println("Post Created Call");
//		System.out.println("=======================");
//	}
//		
//	@PreUpdate
//	private void doBeforeUpdate() {
//		updatedAt = LocalDateTime.now();
//		System.out.println("=======================");
//		System.out.println("Pre Updated Call");
//		System.out.println("=======================");
//	}
//	
//	@PostUpdate
//	private void doAfterUpdate() {
//		createdAt = LocalDateTime.now();
//		System.out.println("=======================");
//		System.out.println("Post Updated Call");
//		System.out.println("=======================");
//	}
//
//	
//	@PreRemove
//	private void doBeforeDelete() {
//		System.out.println("=======================");
//		System.out.println("Pre Removed Call");
//		System.out.println("=======================");
//	}
//	
//	@PostRemove
//	private void doAfterDelete() {
//		System.out.println("=======================");
//		System.out.println("Post Removed Call");
//		System.out.println("=======================");
//	}

}

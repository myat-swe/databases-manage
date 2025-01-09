package com.jdc.cl.entity;

import java.io.Serializable;

import com.jdc.cl.listener.AuditingListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity@Setter@Getter
@Table(name = "contact")
@EntityListeners(AuditingListener.class)
public class Contact extends AuditingEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String phone ;
	
	@Column(nullable = false)
	private String email ;
	
}

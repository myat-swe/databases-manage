package com.jdc.cl.listener;

import java.time.LocalDateTime;

import com.jdc.cl.entity.Account;
import com.jdc.cl.entity.AuditingEntity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class AuditingListener extends AuditingEntity{
	
	private static final long serialVersionUID = 1L;

	@PrePersist
	void deBeforeSave(AuditingEntity entity) {
		System.out.println("Pre persist of %s is called".formatted(entity.getClass().getSimpleName()));
		//entity.setCreateAt(LocalDateTime.now());
		
	}
	
	@PreUpdate
	void doBeforeUpdate(AuditingEntity entity) {
		//account.setUpdateAt(LocalDateTime.now());
	}
	
}

package com.jdc.cl.listener;

import java.time.LocalDateTime;

import com.jdc.cl.entity.AudititngEntity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class AuditingListener {
	
	@PrePersist
	void doBeforeSave(AudititngEntity entity) {
		System.out.println("Pre persist of %s is called.".formatted(entity.getClass().getSimpleName()));
		entity.setCreatedAt(LocalDateTime.now());
	}
	
	@PreUpdate
	void doBeforeUpdate(AudititngEntity entity) {
		System.out.println("Pre update of %s is called.".formatted(entity.getClass().getSimpleName()));
		entity.setUpdatedAt(LocalDateTime.now());
	}

}

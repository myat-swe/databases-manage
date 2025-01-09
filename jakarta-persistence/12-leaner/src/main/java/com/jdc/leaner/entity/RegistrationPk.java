package com.jdc.leaner.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.Data;

@Data

public class RegistrationPk implements Serializable{

	private static final long serialVersionUID = 1L;

	
	
	private Long courseId;
	
	
	private Long learnerId;
//	private Long learnerId;
//
//	private Long courseId;
	
	private LocalDateTime registration_Date;
}

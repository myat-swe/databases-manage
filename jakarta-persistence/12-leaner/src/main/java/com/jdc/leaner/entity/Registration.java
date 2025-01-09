package com.jdc.leaner.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@IdClass(RegistrationPk.class)
@Table(name = "registration")
public class Registration implements Serializable{

	private static final long serialVersionUID = 1L;

//	@Id
//	@Column(nullable = false, name = "course_id")
//	private Long courseId;
//	@Id
//	@Column(nullable = false, name = "learner_id")
//	private Long learnerId;
//	@EmbeddedId
//	private RegistrationPk repk;
//	@Column(nullable = false, name = "registration_fee")
//	private BigDecimal registrationFee;
	@Id
	@ManyToOne()
	@JoinColumn(name = "course_id", referencedColumnName =  "id")
	private Course course;
	@Id
	@ManyToOne
	@JoinColumn(name = "learner_id", referencedColumnName = "id")
	private Learner learner;
	
}

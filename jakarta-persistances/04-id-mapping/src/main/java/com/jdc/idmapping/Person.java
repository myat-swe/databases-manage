package com.jdc.idmapping;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "person_tbl")
@Data
@Setter
@Getter
@SequenceGenerator(name = "PERSON_SEQ", initialValue = 50)
public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "PERSON_SEQ")
	private int id;
	@Column(nullable = false, length = 100)
	private String name;
	private LocalDate dob;
	
	@AttributeOverride(column = @Column(name = "primary_township"),name = "townShip")
	@AttributeOverride(column = @Column(name = "primary_state"), name = "state")
	private Address primaryAddress;
	
	
	@AttributeOverride(column = @Column(name = "secondary_township"),name = "townShip")
	@AttributeOverride(column = @Column(name = "secondary_state"), name = "state")
	private Address secondaryAddress;
	
	
}

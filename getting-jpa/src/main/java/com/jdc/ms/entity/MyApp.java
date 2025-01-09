package com.jdc.ms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "myapp")
public class MyApp {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id ;
	private String name;
}

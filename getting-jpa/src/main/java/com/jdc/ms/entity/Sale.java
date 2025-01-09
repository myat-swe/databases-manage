package com.jdc.ms.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;
@Entity
@Data
@IdClass(SalePk.class)
public class Sale implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private int seqNumber;
	@Id
	private int transiaction;

	private int sale;
	private String description;
	

}

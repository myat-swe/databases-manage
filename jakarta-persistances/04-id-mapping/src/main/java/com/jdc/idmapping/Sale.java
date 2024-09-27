package com.jdc.idmapping;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "sale_tbl")
@Data
public class Sale implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE
	)
	private int id;
	@Id
	private LocalDate saleDate;
	private double total;
	private float taxPer;
	
	@Embedded
	private SalePk salePk;
	

}

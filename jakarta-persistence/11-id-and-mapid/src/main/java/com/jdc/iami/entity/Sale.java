package com.jdc.iami.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "sale")
@IdClass(SalePk.class)
public class Sale implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "customer_id")
	private Long customerId;
	@Id
	@Column(name = "product_id")
	private Long productId;
	
	private LocalDateTime saledate = LocalDateTime.now();
	private double total;
	
	@ManyToOne
	@MapsId("customerId")
	private Customer customer;
	@ManyToOne
	@MapsId("productId")
	private Product product;

}

package com.jdc.iami.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
@Data
@Embeddable
public class SalePk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long customerId;
	private Long productId;
	private LocalDateTime saleDate = LocalDateTime.now();

}

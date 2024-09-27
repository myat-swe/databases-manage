package com.jdc.idmapping;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class SalePk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "sale_id")
	private int saleId;
	@Column(name =  "sale_date")
	private LocalDateTime saleDate;
	
}

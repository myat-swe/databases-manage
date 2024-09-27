package com.jdc.idmapping;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;


@Embeddable
@Data
public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(insertable = false, updatable = false)
	private String townShip;
	
	@Column(unique = true, insertable = false, updatable = false)
	private String state;

}

package com.jdc.ms.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class SalePk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int seqNumber;
	private int transiaction;

}

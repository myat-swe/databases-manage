package com.jdc.ms.collect;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String category;
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private Map<PriceType, Integer> price;
	@ElementCollection
	private List<String> tags;
	@ElementCollection
	@CollectionTable(name = "PRODUCT_FEATURE")
	private Set<Feature> feature;
	
	
	public enum PriceType{
		CUSTOMER, AGENT
	}
}

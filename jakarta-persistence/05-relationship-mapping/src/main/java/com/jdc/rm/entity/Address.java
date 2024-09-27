package com.jdc.rm.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)//primarykeycolumn if u use child entity aviod generate id ;
	@Column(name = "address_id")
	private int addressId;
	@Column(nullable = false)
	private String township;
	@Column(nullable = false, unique = true)
	private String state;
	
//	@ManyToOne(optional = false)
//	@JoinColumn
//	@JoinTable
//	private Customer customer;
	
//	
	@MapsId
	@OneToOne(optional = false)
//	@JoinColumn(name = "customer_id")//1
	@PrimaryKeyJoinColumn//1
//	@JoinTable(joinColumns = @JoinColumn(name = "addr_id"),//1
//				inverseJoinColumns = @JoinColumn(name = "cust_id")
//				//foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
//	)
	private Customer customer;

}
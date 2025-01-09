package com.jdc.ms.collect;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "address")
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 13)
	private String phone;
	@Column(length = 45)
	private String email;
	@Column(length = 59)
	private String address;
	@OneToOne(optional  = false)
	@MapsId
	@PrimaryKeyJoinColumn()
	@JoinColumn(name = "id")
	private Account account;
	
	public void setAccount(Account account) {
		this.account = account;
	    this.id = account.getId();
	}

}

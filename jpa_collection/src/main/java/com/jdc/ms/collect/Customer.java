package com.jdc.ms.collect;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private Contact contact;
	private String name;
}

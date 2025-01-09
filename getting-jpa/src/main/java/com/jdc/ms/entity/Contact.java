package com.jdc.ms.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class Contact implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(nullable = false,table = "contact_tbl")
	private String phone;
	@Column(nullable = false, table = "contact_tbl")
	private String email;
	@Column(nullable = false, table = "contact_tbl")
	private String address;
	@Override
	public int hashCode() {
		return Objects.hash(address, email, phone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(phone, other.phone);
	}
	 
}

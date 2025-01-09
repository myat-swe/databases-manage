package com.jdc.inhm;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Table(name = "office_staff")
public class OfficeStaff extends Employee {

	private static final long serialVersionUID = 1L;

	@Column(precision = 9, scale = 2)
	private BigDecimal salary;

}

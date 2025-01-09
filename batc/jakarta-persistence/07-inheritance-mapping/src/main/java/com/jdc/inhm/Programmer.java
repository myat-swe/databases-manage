package com.jdc.inhm;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@PrimaryKeyJoinColumn(name = "prog_id")
//@Table(name = "programmer")
public class Programmer extends Employee {

	private static final long serialVersionUID = 1L;

	@Column(name = "fee_per_project", precision = 10, scale = 2)
	private BigDecimal feesPerProject;
}

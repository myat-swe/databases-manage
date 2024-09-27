package com.jdc.ms.inher;

import java.math.BigDecimal;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Setter
@Getter
//@Table(name = "programmer")
//@PrimaryKeyJoinColumn(name = "prog_id")(emp use inher.type.joined)
public  class Programmer extends Employee {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "fees_per_project", precision = 12, scale = 2)
	private BigDecimal feesPerProject;

	public BigDecimal getFeesPerProject() {
		return feesPerProject;
	}

	public void setFeesPerProject(BigDecimal feesPerProject) {
		this.feesPerProject = feesPerProject;
	}
	
	
}

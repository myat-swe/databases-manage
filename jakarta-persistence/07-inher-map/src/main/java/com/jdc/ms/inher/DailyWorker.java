package com.jdc.ms.inher;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter@Getter
//@Table(name = "daily_worker")
public class DailyWorker extends Employee{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "daily_fee", precision = 8, scale = 2)
	private BigDecimal dailyFee;

	
}

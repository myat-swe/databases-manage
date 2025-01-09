package com.jdc.ms.collect;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "section")
public class Section implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "start_date", nullable = false)
    private LocalDate startDate;
	@Column(name = "start_time")
	private LocalTime startTime;
	@Column(name = "end")
	private LocalTime endTime;
	@Column(name = "end_date")
	private LocalDate endDate;
	private int duration;
    @ManyToMany
    @JoinTable(name = "tea_id")
	private List<Account> teacher;


}

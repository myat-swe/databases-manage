package com.jdc.em.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "course")
public class Course implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal fees;	
	@Column(nullable = false, name = "start_date")
	private LocalDate startDate;	
	private int duration;
	
	//@ElementCollection
	//@CollectionTable(name = "outline", joinColumns = @JoinColumn(name = "course_id"))
	//@Column(nullable = false, name = "name")
	
	@OneToMany(mappedBy = "course", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
	private List<Outline> outlines = new ArrayList<Outline>();
	
	public void addOutlin(Outline outline) {

		outlines.add(outline);
		outline.setCourse(this);
	}
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Level level;
	
	public enum Level {
		ENTRY, INTERMEDIATE, ADVANCE, PROFESSIONAL
	}

}











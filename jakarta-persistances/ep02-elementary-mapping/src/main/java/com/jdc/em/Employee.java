package com.jdc.em;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee_tbl")
@SecondaryTable(name = "address_tbl",
				uniqueConstraints = @UniqueConstraint(columnNames  = "state"))
@SecondaryTable(
		name = "contact_tbl",

		indexes = {
					@Index(columnList = "email"),
					@Index(columnList = "phone")
				},
		uniqueConstraints = {
				@UniqueConstraint (columnNames = "email")
		}
		)
				
@Setter
@Getter
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = true)
	private double salary;
	
	@Column(precision = 15, scale =3)
	private BigDecimal networth;
	
	@Column(table = "contact_tbl", unique = true, columnDefinition = "varchar(20) check(phone > 0) ")
    private String phone;
	
	@Column(table = "address_tbl", nullable = false)
	private String township;
	@Column(table = "address_tbl", nullable = false)
	private String state;
	@Column(table = "contact_tbl")
	private String email;
	
	@Transient
	private boolean deleted;
	
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	
//	
	@Column(nullable = false, name = "assign_at")
	@Temporal(TemporalType.DATE)
	private Date assignAt;
	
	
	public enum Gender{
		Male,Female
	}
	
//	private Integer wrapInteg;
//	private Date utilDate;
//	
//	private java.util.Calendar utilCalendar;
//	
	
	
//	private java.sql.Date sqlDate;
//	private LocalDate lDate;
//	private LocalTime lTime;
//	private LocalDateTime ldTime;
//	private java.sql.Time sqlTime;
//	private java.sql.Timestamp timestp;
//	private Year jodaYear;
//	private ZonedDateTime zdTime;
//	private OffsetDateTime osDtime;
//	private DayOfWeek doWeek;
//	private Instant jodaInstant;
//	private Month jodaMonth;
//	private Duration jodaDuration;
//	private Period jodaPeriod;
	
	
	
	
	//	private byte age;
//	private short shortCol;
//	private long longCol;
//	private char charCol;
//	private boolean boolCol;
//	private float floatCol;
//	private double doubleCol;
//	private BigInteger bigIntegerCol;
//	private BigDecimal bigDecimalCol;
//	private String stringCol;
//	
//	private byte[] arrayCol;
//	private char[] charColunm;
//	
	
}

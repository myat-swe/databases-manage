package com.jdc.cl.test;

import java.io.Serializable;

import com.jdc.cl.listener.AuditingListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity@Setter@Getter
@Table(name = "transfer_log")
@EntityListeners(value = AuditingListener.class)
public class TransferLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "from_name", nullable = false)
	private String fromName;
	@Column(name = "to_name", nullable = false)
	private String taName;
	@Column(name = "transfer_amount", nullable = false)
	private int transferAmount;
}

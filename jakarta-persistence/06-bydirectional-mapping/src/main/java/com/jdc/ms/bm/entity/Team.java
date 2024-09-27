package com.jdc.ms.bm.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "team_tbl")
@Setter@Getter

public class Team implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, name = "founded_at")
	private LocalDate foundedAt;

	private int trophy;
	
	@OneToMany(mappedBy = "team", cascade = CascadeType.PERSIST)
	private List<Player> player  = new ArrayList<Player>();
	
	//bridge method
	public void addPlayer(Player player) {
		this.player.add(player);
		player.setTeam(this);
	}
}

package com.jdc.bm.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
@Getter
@Setter
@Table(name = "team_tbl")
public class Team implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(name = "founded_at", nullable = false)
	private LocalDate foundedAt;
	private int trophy;
	
//	//Using List
//	@OneToMany(mappedBy = "team", cascade = CascadeType.PERSIST)
//	private List<Player> players = new ArrayList<>();
	
	//using set
	@OneToMany(mappedBy = "team", cascade = CascadeType.PERSIST)
	private Set<Player> players = new HashSet<Player>();
	
	//Bridge method
	public void addPlayer(Player player) {
		this.players.add(player);
		player.setTeam(this);
	}

}

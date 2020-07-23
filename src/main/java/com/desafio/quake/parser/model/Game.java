package com.desafio.quake.parser.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Game implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "total_kills")
	private Long totalKills;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Player> players;
	
	public Game() {
		players = new ArrayList<Player>();
	}
	
	public Game(Long id, Long totalKills, List<Player> players) {
		this.id = id;
		this.totalKills = totalKills;
		this.players = players;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTotalKills() {
		return totalKills;
	}

	public void setTotalKills(Long totalKills) {
		this.totalKills = totalKills;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public void addKill() {
		if(totalKills == null) {
			totalKills = (long) 0;
		}
		totalKills++;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", totalKills=" + totalKills + ", players=" + players + "]";
	}
	
	
}

package com.desafio.quake.parser.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userName;
	private Long kills;
	
	public Player() {
		
	}
	
	public Player(Long id, String userName, Long kills) {
		this.id = id;
		this.userName = userName;
		this.kills = kills;
	}
	
	public Player(String userName, Long kills) {
		this.userName = userName;
		this.kills = kills;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getKills() {
		return kills;
	}

	public void setKills(Long kills) {
		this.kills = kills;
	}
	
	public void addKill() {
		this.kills += 1;
	}

	public void removeKill() {
		if (this.kills > 0) {
			this.kills -= 1;
		}
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", userName=" + userName + ", kills=" + kills + "]";
	}
	
	
}

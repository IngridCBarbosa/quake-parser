package com.desafio.quake.parser.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private List<String> players;
	private Map<String, Long>kills;
	
	public GameDTO(Long id) {
		this.id = id;
	}
	
	public GameDTO() {
		players = new ArrayList<String>();
		kills = new HashMap<String, Long>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getPlayers() {
		return players;
	}

	public void setPlayers(List<String> players) {
		this.players = players;
	}

	public Map<String, Long> getKills() {
		return kills;
	}

	public void setKills(Map<String, Long> kills) {
		this.kills = kills;
	}
	
	

}

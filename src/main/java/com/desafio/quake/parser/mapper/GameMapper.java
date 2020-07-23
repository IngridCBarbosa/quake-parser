package com.desafio.quake.parser.mapper;

import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.desafio.quake.parser.DTO.GameDTO;
import com.desafio.quake.parser.DTO.MetaDTO;
import com.desafio.quake.parser.DTO.ResponseDTO;
import com.desafio.quake.parser.model.Game;
import com.desafio.quake.parser.model.Player;

@Component
public class GameMapper {
	
	
	
	
	public ResponseDTO map(Page<Game> games) {
		ResponseDTO response = new ResponseDTO();
		response.setAllRecords(games.stream().map(new Function<Game, Object>() {
			public Object apply(Game game) {
				return mapSingleGame(game);
			}
		}).collect(Collectors.toList()));
		response.setMeta(new MetaDTO(games.getPageable().getPageSize(), games.getPageable().getPageNumber(), games.getNumberOfElements(), games.getTotalElements()));
		
		return response;
	}
	
	private GameDTO mapSingleGame(Game game) {
		GameDTO response = new GameDTO(game.getId());
		
		game.getPlayers().forEach((Player player) -> {
			response.getPlayers().add(player.getUserName());
			response.getKills().put(player.getUserName(), player.getKills());
		});
		
		return response;
	}
}

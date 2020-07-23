package com.desafio.quake.parser.Iservice;

import com.desafio.quake.parser.model.Game;
import org.springframework.data.domain.Page;

public interface IGameService {
	
	public Page<Game> findAll(Integer offset, Integer limit);
	
	public Game save(Game game);
	
	public Game findById(Long id);
}

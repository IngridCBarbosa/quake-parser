package com.desafio.quake.parser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.desafio.quake.parser.Iservice.IGameService;
import com.desafio.quake.parser.model.Game;
import com.desafio.quake.parser.repository.GameRepository;
import com.desafio.quake.parser.repository.PlayerRepository;

import org.hibernate.ObjectNotFoundException;


@Service
public class GameService implements IGameService{
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Override
	public Page<Game> findAll(Integer offset, Integer limit) {
		Page<Game> pageGame = gameRepository.findAll(PageRequest.of(offset, limit));
		
		if(pageGame.isEmpty()) {
			throw new ObjectNotFoundException(null, Game.class.getName());
		}
		return pageGame;
	}

	@Override
	public Game save(Game game) {
		game.getPlayers().forEach(playerRepository::save);
		return gameRepository.save(game);
	}

	@Override
	public Game findById(Long id) {
		
		return gameRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id,Game.class.getName()));
	}

}

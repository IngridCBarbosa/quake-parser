package com.desafio.quake.parser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.desafio.quake.parser.Iservice.IGameService;
import com.desafio.quake.parser.model.Game;
import com.desafio.quake.parser.parser.Parser;




@SpringBootApplication
public class Main {
	
	private final String fileName = "games.log";
	
	@Autowired
	private IGameService service;
	
	@Autowired
	private Parser parser;
	
	public static void main(String [] args) {
		SpringApplication.run(Main.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void afterStart() throws IOException, URISyntaxException {
		
		List<Game> allGames = parser.startParser(fileName);
		allGames.forEach(new Consumer<Game>() {
			public void accept(Game game) {
				service.save(game);
			}
		});
		
	}

}

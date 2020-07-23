package com.desafio.quake.parser.parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.desafio.quake.parser.model.Game;
import com.desafio.quake.parser.model.Player;

@Component
public class Parser {

	private List<Game> games;
	private Game game;

	private final String INIT_GAME = ".*InitGame:.*";
	private final String END_GAME = ".*ShutdownGame:.*";
	private final String KILLER = "killer";
	private final String KILLED = "killed";
	private final String KILL = ".*\\skilled\\s.*";
	private final String WORLD = "<world>";
	private final Pattern killPattern = Pattern.compile("([^:]+)killed(.*?)\\sby");

	public List<Game> startParser(String fileName) throws IOException, URISyntaxException {
		games = new ArrayList<Game>();
		
		Stream<String> lines = readFile(fileName);
		lines.forEach(this::pasingLine);
		lines.close();
		return games;
	}

	private Stream<String> readFile(String fileName) throws IOException, URISyntaxException {
		URL url = ClassLoader.getSystemResource(fileName);
		
		if (url != null) {
			return Files.lines(Paths.get(url.toURI()));
		}
		
		throw new FileNotFoundException(String.format("Arquivo %s não encontrado", fileName));
	}

	private void pasingLine(String line) {

		if (line.matches(INIT_GAME)) {
			startNewGame();
		} else if (line.matches(KILL)) {

			game.addKill();
			
			Map<String, String> killInformation = parserPlayerLine(line);
			String userNamePlayer = killInformation.get(KILLER);

			if (WORLD.equals(userNamePlayer)) {

				Player playerKilled = getPlayer(killInformation.get(KILLED));
				Player playerKiller = getPlayer(killInformation.get(KILLER));

				if (playerKiller.getUserName().equals(playerKilled.getUserName()) == false) {
					playerKiller.addKill();
				}
			}

		} else if (line.matches(END_GAME)) {
			endGame();
		}
	}

	private Map<String, String> parserPlayerLine(String line) {
		Map<String, String> killInformation = new HashMap<String, String>();
		Matcher matcher = killPattern.matcher(line);
		
		if (matcher.find()) {
			killInformation.put(KILLER, matcher.group(1).trim());
			killInformation.put(KILLED, matcher.group(2).trim());
		}
		
		return killInformation;
	}

	private Player getPlayer(String userName) {
		Optional<Player> currentPlayer = this.game.getPlayers().stream().filter(player -> player.getUserName().equals(userName)).findFirst();
		if (currentPlayer.isEmpty()) {
			Player player = new Player(userName, 0l);
			this.game.getPlayers().add(player);
			return player;
		}
		return currentPlayer.get();
	}

	private void startNewGame() {
		if(game != null) {
			endGame();
		}
		game = new Game();
	}

	private void endGame() {
		games.add(game);
		game = null;
	}
}

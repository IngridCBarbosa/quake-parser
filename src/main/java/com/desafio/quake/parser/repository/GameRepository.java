package com.desafio.quake.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.quake.parser.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}

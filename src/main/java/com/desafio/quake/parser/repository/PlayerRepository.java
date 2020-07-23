package com.desafio.quake.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.quake.parser.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}

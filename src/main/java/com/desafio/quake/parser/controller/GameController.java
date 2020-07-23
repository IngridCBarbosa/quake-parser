package com.desafio.quake.parser.controller;

import java.util.Arrays;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.desafio.quake.parser.DTO.ResponseDTO;
import com.desafio.quake.parser.Iservice.IGameService;
import com.desafio.quake.parser.mapper.GameMapper;
import com.desafio.quake.parser.model.Game;

@RestController
@RequestMapping("v1/desafio")
@Validated
public class GameController {
	
	@Autowired
	private GameMapper parser;
	@Autowired
	private IGameService gameService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ResponseDTO> findAll(@RequestParam(value = "offset", defaultValue = "0") Integer offset, @RequestParam(value = "limit", defaultValue = "10") Integer limit) {

		return ResponseEntity.ok(this.parser.map(this.gameService.findAll(offset, limit)));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<ResponseDTO> findById(@PathVariable @Min(value = 1, message = "id must be greater than or equal 1") Long id){
		
		return ResponseEntity.ok(parser.map(new PageImpl<Game>(Arrays.asList(this.gameService.findById(id)), PageRequest.of(0, 1), 0l)));
	}
	
}

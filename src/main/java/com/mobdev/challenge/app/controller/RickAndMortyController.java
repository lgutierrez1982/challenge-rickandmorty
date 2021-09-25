package com.mobdev.challenge.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobdev.challenge.app.dto.CharacterDto;
import com.mobdev.challenge.app.service.IRickAndMortyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api")
@Api(tags = "challenge")
public class RickAndMortyController {
	
	@Autowired
	private IRickAndMortyService iRickAndMortyService;
	
	
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Obtener personaje por Id", notes = "Servicio para obtener un personaje")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Personaje encontrado"),
			@ApiResponse(code = 404, message = "Personaje no encontrado")})
	public CharacterDto findCharacterById(@PathVariable Integer id) {
		
		return iRickAndMortyService.findCharacterById(id);
		
	}



}

package com.mobdev.challenge.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobdev.challenge.app.converter.CharacterConverter;
import com.mobdev.challenge.app.dto.CharacterDto;
import com.mobdev.challenge.app.entity.CharacterEntity;
import com.mobdev.challenge.app.entity.LocationEntity;
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
	public ResponseEntity<CharacterDto> findCharacterById(@PathVariable Integer id) {
		
		Optional<CharacterEntity> character = iRickAndMortyService.findCharacterById(id);
		
		if(!character.isPresent()) {
			return ResponseEntity.notFound().build(); 
		}
		
		Optional<LocationEntity> location = iRickAndMortyService.findLocationById(character.get().getOrigin().getUrl());
		
		if(location.isPresent()) {
			character.get().setOrigin(location.get());
		}
		
		//Convert to from Entity to Dto object
		CharacterConverter converter = new CharacterConverter();
		
		return ResponseEntity.ok(converter.fromEntity(character.get()));
	}


}

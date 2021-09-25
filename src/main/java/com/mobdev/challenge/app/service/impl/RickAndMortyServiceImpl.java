package com.mobdev.challenge.app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.mobdev.challenge.app.converter.CharacterConverter;
import com.mobdev.challenge.app.dto.CharacterDto;
import com.mobdev.challenge.app.entity.CharacterEntity;
import com.mobdev.challenge.app.entity.LocationEntity;
import com.mobdev.challenge.app.exception.BusinessException;
import com.mobdev.challenge.app.exception.CharacterNotFoundException;
import com.mobdev.challenge.app.gateway.IRickAndMortyGateway;
import com.mobdev.challenge.app.service.IRickAndMortyService;

@Service
public class RickAndMortyServiceImpl implements IRickAndMortyService {

	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass()); 
	
	@Autowired
	private IRickAndMortyGateway iRickAndMortyGateway;

	
	@Override
	public CharacterDto findCharacterById(Integer id) {
		
		ResponseEntity<CharacterEntity> characterEntity = null;
		
		ResponseEntity<LocationEntity> locationEntity;
		
		try {
			
			characterEntity = iRickAndMortyGateway.findCharacterById(id);
			
			
			if(characterEntity.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
				
				LOGGER.info("Character not found by Id {}", id);
				
				throw new CharacterNotFoundException();
			}
			
			if(characterEntity.getBody().getOrigin().getUrl() != null && characterEntity.getBody().getOrigin().getUrl().trim().length() > 0) {
				
				locationEntity = iRickAndMortyGateway.findLocationById(characterEntity.getBody().getOrigin().getUrl());
				
				characterEntity.getBody().setOrigin(locationEntity.getBody());
				
			}
		
		
		}catch(HttpClientErrorException.NotFound ex){
			
			throw new CharacterNotFoundException();
			
		}catch (Exception e) {
			
			LOGGER.error("Unexpected Error on process EndPoint by Id", e.getMessage());
			
			throw new BusinessException();
		}
		
		CharacterConverter converter = new CharacterConverter();
		
		return converter.fromEntity(characterEntity.getBody());
		
	}


}

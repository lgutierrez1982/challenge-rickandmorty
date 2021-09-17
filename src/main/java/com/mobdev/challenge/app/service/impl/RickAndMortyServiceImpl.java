package com.mobdev.challenge.app.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.mobdev.challenge.app.entity.CharacterEntity;
import com.mobdev.challenge.app.entity.LocationEntity;
import com.mobdev.challenge.app.gateway.IRickAndMortyGateway;
import com.mobdev.challenge.app.service.IRickAndMortyService;

@Service
public class RickAndMortyServiceImpl implements IRickAndMortyService {

	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass()); 
	
	@Autowired
	private IRickAndMortyGateway iRickAndMortyGateway;

	@Override
	public Optional<CharacterEntity> findCharacterById(Integer id) {
		
		Optional<CharacterEntity> characterEntity = Optional.empty();
		
		try {
			
			characterEntity = iRickAndMortyGateway.findCharacterById(id);
		
		}catch (HttpClientErrorException.NotFound e) {
			
			LOGGER.info("Not found Character by Id {}", id);
			
		}catch (Exception e) {
			
			LOGGER.error("Unexpected Error on process EndPoint by Id", e.getMessage());
		}
		
		
		return characterEntity;
		
	}
	
	public Optional<LocationEntity> findLocationById(String url) {
		
		Optional<LocationEntity> locationEntity = Optional.empty();
		
		try {
			
			locationEntity = iRickAndMortyGateway.findLocationById(url);
			
		
		}catch (HttpClientErrorException.NotFound e) {
			
			LOGGER.info("Not found Location by url {}", url);
			
		}catch (Exception e) {
			
			LOGGER.error("Unexpected Error on process Location by url {}",url);
		}
		
		return locationEntity;
	
	}


}

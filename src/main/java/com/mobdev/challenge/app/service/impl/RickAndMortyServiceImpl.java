package com.mobdev.challenge.app.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.mobdev.challenge.app.config.EndPoint;
import com.mobdev.challenge.app.entity.CharacterEntity;
import com.mobdev.challenge.app.entity.LocationEntity;
import com.mobdev.challenge.app.service.IRickAndMortyService;

@Service
public class RickAndMortyServiceImpl implements IRickAndMortyService {

	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass()); 
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EndPoint endpointUrl;
		

	@Override
	public Optional<CharacterEntity> getCharacterById(Integer id) {
		
		Optional<CharacterEntity> optional = Optional.empty();
		
		try {
			
			optional = Optional.ofNullable(restTemplate.getForObject(endpointUrl.getCharacterById() + "{id}", CharacterEntity.class, id));
			
		
		}catch (HttpClientErrorException.NotFound e) {
			
			LOGGER.info("Not found Character into EndPoint {} by Id {}", endpointUrl.getCharacterById(), id);
			
		}catch (Exception e) {
			
			LOGGER.error("Unexpected Error on process EndPoint {} by Id {}", endpointUrl.getCharacterById(), id);
		}
		
		
		return optional;
		
	}
	
	public Optional<LocationEntity> getLocationById(String url) {
		
		Optional<LocationEntity> optional = Optional.empty();
		
		try {
			
			optional = Optional.ofNullable(restTemplate.getForObject(url, LocationEntity.class));
			
		
		}catch (HttpClientErrorException.NotFound e) {
			
			LOGGER.info("Not found Character into EndPoint Location {}", url);
			
		}catch (Exception e) {
			
			LOGGER.error("Unexpected Error on process EndPoint Location {}",url);
		}
		
		
		return optional;
		
	}
	
	@Override
	public Optional<CharacterEntity> getCharacterChallengeById(Integer id) {
		
		Optional<CharacterEntity> character = Optional.empty();
		Optional<LocationEntity>  location = Optional.empty();
		
		try {
			
			character = Optional.ofNullable(restTemplate.getForObject(endpointUrl.getCharacterById() + "{id}", CharacterEntity.class, id));
			
			if(character.isPresent()) {
				location = this.getLocationById(character.get().getOrigin().getUrl());
			}
			
			if(location.isPresent()) {
				character.get().setOrigin(location.get());
			}
		
		}catch (HttpClientErrorException.NotFound e) {
			
			LOGGER.info("Not found Character into EndPoint {} by Id {}", endpointUrl.getCharacterById(), id);
			
		}catch (Exception e) {
			
			LOGGER.error("Unexpected Error on process EndPoint {} by Id {}", endpointUrl.getCharacterById(), id);
		}
		
		
		return character;
		
	}
	

}

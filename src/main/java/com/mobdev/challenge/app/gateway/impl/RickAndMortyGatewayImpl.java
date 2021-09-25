package com.mobdev.challenge.app.gateway.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mobdev.challenge.app.config.EndPoint;
import com.mobdev.challenge.app.entity.CharacterEntity;
import com.mobdev.challenge.app.entity.LocationEntity;
import com.mobdev.challenge.app.gateway.IRickAndMortyGateway;

@Component
public class RickAndMortyGatewayImpl implements IRickAndMortyGateway{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EndPoint endpointUrl;
	
	
	@Override
	public ResponseEntity<CharacterEntity> findCharacterById(Integer id) {
		
		return restTemplate.getForEntity(endpointUrl.getCharacterById() + "{id}", CharacterEntity.class, id);
		
	}
	
	@Override
	public ResponseEntity<LocationEntity> findLocationById(String url) {
		
		return restTemplate.getForEntity(url, LocationEntity.class);
			
	}

}

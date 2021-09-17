package com.mobdev.challenge.app.gateway.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Optional<CharacterEntity> findCharacterById(Integer id) {
		
		return Optional.ofNullable(restTemplate.getForObject(endpointUrl.getCharacterById() + "{id}", 
								   							 CharacterEntity.class, 
								   							 id));
			
	}
	
	@Override
	public Optional<LocationEntity> findLocationById(String url) {
		
		return Optional.ofNullable(restTemplate.getForObject(url, LocationEntity.class));
			
	}

}

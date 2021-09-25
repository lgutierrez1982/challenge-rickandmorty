package com.mobdev.challenge.app.gateway;

import org.springframework.http.ResponseEntity;

import com.mobdev.challenge.app.entity.CharacterEntity;
import com.mobdev.challenge.app.entity.LocationEntity;

public interface IRickAndMortyGateway {
	
	ResponseEntity<CharacterEntity> findCharacterById(Integer id);

	ResponseEntity<LocationEntity> findLocationById(String url);

}

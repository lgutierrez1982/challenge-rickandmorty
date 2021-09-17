package com.mobdev.challenge.app.gateway;

import java.util.Optional;

import com.mobdev.challenge.app.entity.CharacterEntity;
import com.mobdev.challenge.app.entity.LocationEntity;

public interface IRickAndMortyGateway {
	
	Optional<CharacterEntity> findCharacterById(Integer id);

	Optional<LocationEntity> findLocationById(String url);

}

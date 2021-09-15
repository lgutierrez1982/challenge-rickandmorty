package com.mobdev.challenge.app.service;

import java.util.Optional;

import com.mobdev.challenge.app.entity.CharacterEntity;
import com.mobdev.challenge.app.entity.LocationEntity;

public interface IRickAndMortyService {
	
	public Optional<CharacterEntity> getCharacterById(Integer id);
	
	public Optional<LocationEntity> getLocationById(String url);
	
	public Optional<CharacterEntity> getCharacterChallengeById(Integer id);

}

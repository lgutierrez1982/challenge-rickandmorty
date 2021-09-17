package com.mobdev.challenge.app.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mobdev.challenge.app.entity.CharacterEntity;
import com.mobdev.challenge.app.entity.LocationEntity;
import com.mobdev.challenge.app.gateway.IRickAndMortyGateway;


public class RickAndMortyServiceImplTest {
	
	@Mock
	private IRickAndMortyGateway iRickAndMortyGateway;
	
	@InjectMocks
	private RickAndMortyServiceImpl rickAndMortyServiceImpl;
	
	private Optional<CharacterEntity> optionalCharacterEntity;
	
	private Optional<LocationEntity> optionalLocationEntityEntity;
	
	@BeforeEach
	void setup() {
		
		MockitoAnnotations.openMocks(this);

		CharacterEntity characterEntity = new CharacterEntity();
		characterEntity.setId(1);
		characterEntity.setName("Rick");
		characterEntity.setSpecies("species");
		optionalCharacterEntity = Optional.of(characterEntity);
		
		LocationEntity locationEntity = new LocationEntity();
		locationEntity.setName("Earth");
		locationEntity.setDimension("Unknow dimension");
		locationEntity.setCreated(LocalDateTime.now());
		optionalLocationEntityEntity = Optional.of(locationEntity);
	
	}
	
	@Test
	public void findCharacterById() {
		
		when(iRickAndMortyGateway.findCharacterById(1)).thenReturn(optionalCharacterEntity);
		assertNotNull(rickAndMortyServiceImpl.findCharacterById(1));
		
	}
	
	@Test
	public void findLocationById() {
		
		when(iRickAndMortyGateway.findLocationById("https://rickandmortyapi.com/api/location/1"))
				.thenReturn(optionalLocationEntityEntity);
		assertNotNull(rickAndMortyServiceImpl.findLocationById("https://rickandmortyapi.com/api/location/1"));
		
	}

}

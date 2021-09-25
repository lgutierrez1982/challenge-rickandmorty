package com.mobdev.challenge.app.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.mobdev.challenge.app.entity.CharacterEntity;
import com.mobdev.challenge.app.entity.LocationEntity;
import com.mobdev.challenge.app.gateway.IRickAndMortyGateway;


public class RickAndMortyServiceImplTest {
	
	@Mock
	private IRickAndMortyGateway iRickAndMortyGateway;
	
	@InjectMocks
	private RickAndMortyServiceImpl rickAndMortyServiceImpl;
	
	private CharacterEntity characterEntity;
	
	private LocationEntity locationEntity;
	
	@BeforeEach
	void setup() {
		
		MockitoAnnotations.openMocks(this);

		characterEntity = new CharacterEntity();
		characterEntity.setId(1);
		characterEntity.setName("Rick");
		characterEntity.setSpecies("species");
		characterEntity.setEpisode(new ArrayList<String>());
		
		
		locationEntity = new LocationEntity();
		locationEntity.setName("Earth");
		locationEntity.setDimension("Unknow dimension");
		locationEntity.setCreated(LocalDateTime.now());
		locationEntity.setUrl("https://rickandmortyapi.com/api/location/1");
		
		characterEntity.setOrigin(locationEntity);
		
	
	}
	
	@Test
	public void findCharacterById() {
		
		when(iRickAndMortyGateway.findLocationById(anyString())).thenReturn(ResponseEntity.status(200).body(locationEntity));
		when(iRickAndMortyGateway.findCharacterById(anyInt())).thenReturn(ResponseEntity.status(200).body(characterEntity));
		
		assertNotNull(rickAndMortyServiceImpl.findCharacterById(1));
		
	}

}

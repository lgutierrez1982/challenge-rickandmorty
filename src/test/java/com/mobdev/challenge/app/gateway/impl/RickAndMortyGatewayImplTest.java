package com.mobdev.challenge.app.gateway.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.mobdev.challenge.app.entity.CharacterEntity;
import com.mobdev.challenge.app.entity.LocationEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RickAndMortyGatewayImplTest {
	
	@Autowired
	private TestRestTemplate client;
	
	@Test
	public void findCharacterById() {
		ResponseEntity<CharacterEntity> response = client.getForEntity("https://rickandmortyapi.com/api/character/{id}", CharacterEntity.class, 1);
		assertNotNull(response);
	}
	
	@Test
	public void findLocationById() {
		ResponseEntity<LocationEntity> response = client.getForEntity("https://rickandmortyapi.com/api/location/1", LocationEntity.class);
		assertNotNull(response);
	}
}

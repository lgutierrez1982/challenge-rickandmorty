package com.mobdev.challenge.app.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.mobdev.challenge.app.entity.CharacterEntity;
import com.mobdev.challenge.app.entity.LocationEntity;
import com.mobdev.challenge.app.service.IRickAndMortyService;

@WebMvcTest(RickAndMortyController.class)
@AutoConfigureMockMvc
public class RickAndMortyControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IRickAndMortyService iRickAndMortyService;
	
	private Optional<CharacterEntity> optionalCharacterEntity;
	
	@MockBean
	public RestTemplate restTemplate;
	
	@BeforeEach
	void setup() {
		
		CharacterEntity characterEntity = new CharacterEntity();
		characterEntity.setId(1);
		characterEntity.setName("Rick");
		characterEntity.setEpisode(new ArrayList<String>());
		characterEntity.setOrigin(new LocationEntity());
		characterEntity.getOrigin().setUrl("https://rickandmortyapi.com/api/location/1");
		characterEntity.setLocation(new LocationEntity());
	    
		optionalCharacterEntity = Optional.of(characterEntity);
	
	}
	
	@Test
	public void findCharacterById() throws Exception {
		//given
		when(iRickAndMortyService.findCharacterById(1)).thenReturn(optionalCharacterEntity);
		
		//when
		mvc.perform(MockMvcRequestBuilders.get("/api/{id}",1).contentType(MediaType.APPLICATION_JSON))
		
		//then
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.name").value("Rick"));
		
		verify(iRickAndMortyService).findCharacterById(1);
		
	}
	
	
	

}

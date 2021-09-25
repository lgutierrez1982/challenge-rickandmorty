package com.mobdev.challenge.app.controller;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.mobdev.challenge.app.dto.CharacterDto;
import com.mobdev.challenge.app.dto.LocationDto;
import com.mobdev.challenge.app.service.IRickAndMortyService;

@WebMvcTest(RickAndMortyController.class)
@AutoConfigureMockMvc
public class RickAndMortyControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IRickAndMortyService iRickAndMortyService;
	
	private CharacterDto characterDto;
	
	@MockBean
	public RestTemplate restTemplate;
	
	@BeforeEach
	void setup() {
		
		characterDto = new CharacterDto();
		characterDto.setId(1);
		characterDto.setName("Rick");
		characterDto.setEpisodeCount(21);
		characterDto.setLocationDto(new LocationDto());
	
	}
	
	@Test
	public void findCharacterById() throws Exception {
		//given
		when(iRickAndMortyService.findCharacterById(anyInt())).thenReturn(characterDto);
		
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

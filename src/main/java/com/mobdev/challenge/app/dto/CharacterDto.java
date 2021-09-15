package com.mobdev.challenge.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class CharacterDto {
	
	@Getter @Setter
	private long id;
	
	@Getter @Setter
    private String name;
	
	@Getter @Setter
    private String status;
	
	@Getter @Setter
    private String species;
	
	@Getter @Setter
    private String type;
	
	@Getter @Setter
	@JsonProperty("episode_count")
    private Integer episodeCount;
	
	@Getter @Setter
	@JsonProperty("origin")
	private LocationDto locationDto;

	
}

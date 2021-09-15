package com.mobdev.challenge.app.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class LocationDto {
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private String url;
	
	@Getter @Setter
	private String dimension;
	
	@Getter @Setter
	private List<String> residents;

}

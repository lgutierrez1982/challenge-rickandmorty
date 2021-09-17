package com.mobdev.challenge.app.converter;

import java.util.stream.Collectors;

import com.mobdev.challenge.app.dto.LocationDto;
import com.mobdev.challenge.app.entity.LocationEntity;

public class LocationConverter extends AbstractConverter<LocationEntity, LocationDto>{
	
	@Override
	public LocationEntity fromDto(LocationDto dto) {
		//NO IMPL
		return null;
	}
	
	@Override
	public LocationDto fromEntity(LocationEntity entity) {
		
		LocationDto locationDto = new LocationDto();
		
		locationDto.setName(entity.getName());
		locationDto.setUrl(entity.getUrl());
		locationDto.setDimension(entity.getDimension());
		
		//Prevent NullPointerException
		if(entity.getResidents()!=null) {
			locationDto.setResidents(entity.getResidents().stream().collect(Collectors.toList()));
		}
		
		return locationDto;
	}


}

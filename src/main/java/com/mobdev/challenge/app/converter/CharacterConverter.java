package com.mobdev.challenge.app.converter;

import com.mobdev.challenge.app.dto.CharacterDto;
import com.mobdev.challenge.app.entity.CharacterEntity;

public class CharacterConverter extends AbstractConverter<CharacterEntity, CharacterDto>{

	private final LocationConverter LocationConverter = new LocationConverter();
	
	@Override
	public CharacterEntity fromDto(CharacterDto dto) {

		//NO IMPL
		return null;
	}

	@Override
	public CharacterDto fromEntity(CharacterEntity entity) {

		CharacterDto characterDto = new CharacterDto();
		
		characterDto.setId(entity.getId());
		characterDto.setName(entity.getName());
		characterDto.setStatus(entity.getStatus());
		characterDto.setSpecies(entity.getSpecies());
		characterDto.setType(entity.getType());
		characterDto.setEpisodeCount(entity.getEpisode().size());
		characterDto.setLocationDto(LocationConverter.fromEntity(entity.getOrigin()));
		
		return characterDto;
	}

}

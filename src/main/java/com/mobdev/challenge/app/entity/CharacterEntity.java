package com.mobdev.challenge.app.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterEntity {
	
	private long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private LocationEntity origin;
    private LocationEntity location;
    private String image;
    private List<String> episode;
    private String url;
    private LocalDateTime created;

	@JsonProperty("id")
	public long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(long value) {
		this.id = value;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String value) {
		this.name = value;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String value) {
		this.status = value;
	}

	@JsonProperty("species")
	public String getSpecies() {
		return species;
	}

	@JsonProperty("species")
	public void setSpecies(String value) {
		this.species = value;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String value) {
		this.type = value;
	}

	@JsonProperty("gender")
	public String getGender() {
		return gender;
	}

	@JsonProperty("gender")
	public void setGender(String value) {
		this.gender = value;
	}

	@JsonProperty("origin")
	public LocationEntity getOrigin() {
		return origin;
	}

	@JsonProperty("origin")
	public void setOrigin(LocationEntity value) {
		this.origin = value;
	}

	@JsonProperty("location")
	public LocationEntity getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(LocationEntity value) {
		this.location = value;
	}

	@JsonProperty("image")
	public String getImage() {
		return image;
	}

	@JsonProperty("image")
	public void setImage(String value) {
		this.image = value;
	}

	@JsonProperty("episode")
	public List<String> getEpisode() {
		return episode;
	}

	@JsonProperty("episode")
	public void setEpisode(List<String> value) {
		this.episode = value;
	}

	@JsonProperty("url")
	public String getURL() {
		return url;
	}

	@JsonProperty("url")
	public void setURL(String value) {
		this.url = value;
	}

	@JsonProperty("created")
	public LocalDateTime getCreated() {
		return created;
	}

	@JsonProperty("created")
	public void setCreated(LocalDateTime value) {
		this.created = value;
	}

}

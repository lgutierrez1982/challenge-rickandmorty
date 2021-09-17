package com.mobdev.challenge.app.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationEntity {

	private long id;
	private String name;
	private String type;
	private String dimension;
	private List<String> residents;
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

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String value) {
		this.type = value;
	}

	@JsonProperty("dimension")
	public String getDimension() {
		return dimension;
	}

	@JsonProperty("dimension")
	public void setDimension(String value) {
		this.dimension = value;
	}

	@JsonProperty("residents")
	public List<String> getResidents() {
		return residents;
	}

	@JsonProperty("residents")
	public void setResidents(List<String> value) {
		this.residents = value;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String value) {
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

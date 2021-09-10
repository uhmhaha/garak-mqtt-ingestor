package com.garak.ingestor.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true) //추후삭제 
public class Gps {
	@JsonProperty("Created")
	private long Created;
	@JsonProperty("Yaw")
	private double Yaw;
	@JsonProperty("Pitch")
	private double Pitch;
	@JsonProperty("Roll")
	private double Roll;
	@JsonProperty("QuaternionW")
	private double QuaternionW;
	@JsonProperty("QuaternionX")
	private double QuaternionX;
	@JsonProperty("QuaternionY")
	private double QuaternionY;
	@JsonProperty("QuaternionZ")
	private double QuaternionZ;
	@JsonProperty("Latitude")
	private double Latitude;
	@JsonProperty("Longitude")
	private double Longitude;
}

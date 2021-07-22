package com.garak.ingestor.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Gps {
	private int Created;
	private double Yaw;
	private double Pitch;
	private double Roll;
	private double QuaternionW;
	private double QuaternionX;
	private double QuaternionY;
	private double QuaternionZ;
	private double Latitude;
	private double Longitude;
}

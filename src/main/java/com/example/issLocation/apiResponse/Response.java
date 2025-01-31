package com.example.issLocation.apiResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

	@JsonProperty("altitude")
	private Object altitude;

	@JsonProperty("visibility")
	private String visibility;

	@JsonProperty("latitude")
	private Object latitude;

	@JsonProperty("velocity")
	private Object velocity;

	@JsonProperty("units")
	private String units;

	@JsonProperty("footprint")
	private Object footprint;

	@JsonProperty("solar_lon")
	private Object solarLon;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("solar_lat")
	private Object solarLat;

	@JsonProperty("daynum")
	private Object daynum;

	@JsonProperty("longitude")
	private Object longitude;

	@JsonProperty("timestamp")
	private int timestamp;

	public void setAltitude(Object altitude){
		this.altitude = altitude;
	}

	public Object getAltitude(){
		return altitude;
	}

	public void setVisibility(String visibility){
		this.visibility = visibility;
	}

	public String getVisibility(){
		return visibility;
	}

	public void setLatitude(Object latitude){
		this.latitude = latitude;
	}

	public Object getLatitude(){
		return latitude;
	}

	public void setVelocity(Object velocity){
		this.velocity = velocity;
	}

	public Object getVelocity(){
		return velocity;
	}

	public void setUnits(String units){
		this.units = units;
	}

	public String getUnits(){
		return units;
	}

	public void setFootprint(Object footprint){
		this.footprint = footprint;
	}

	public Object getFootprint(){
		return footprint;
	}

	public void setSolarLon(Object solarLon){
		this.solarLon = solarLon;
	}

	public Object getSolarLon(){
		return solarLon;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setSolarLat(Object solarLat){
		this.solarLat = solarLat;
	}

	public Object getSolarLat(){
		return solarLat;
	}

	public void setDaynum(Object daynum){
		this.daynum = daynum;
	}

	public Object getDaynum(){
		return daynum;
	}

	public void setLongitude(Object longitude){
		this.longitude = longitude;
	}

	public Object getLongitude(){
		return longitude;
	}

	public void setTimestamp(int timestamp){
		this.timestamp = timestamp;
	}

	public int getTimestamp(){
		return timestamp;
	}
}
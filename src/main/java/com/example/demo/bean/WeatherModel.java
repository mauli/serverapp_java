package com.example.demo.bean;

import java.util.Date;


public class WeatherModel {

	private String siteid;
	
	private String humidity;

	private String temperature;

	private String windspeed;
	
	private Date createdate;
	

	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWindspeed() {
		return windspeed;
	}

	public void setWindspeed(String windspeed) {
		this.windspeed = windspeed;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "Weather [siteid=" + siteid + ", humidity=" + humidity + ", temperature="
				+ temperature + "]";
	}
	
}

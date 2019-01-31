package com.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "weather")
public class Weather implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // primary key
	@Column(name = "weather_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // how the value of the primary key would be generated
	private Long weatherID;

	@NotBlank
	private String siteid;
	
	@NotBlank
	private String humidity;

	@NotBlank
	private String temperature;

	@NotBlank
	private String windspeed;
	
	private Date createdate;
	
	public Long getWeatherID() {
		return weatherID;
	}

	public void setWeatherID(Long weatherID) {
		this.weatherID = weatherID;
	}

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

	
}

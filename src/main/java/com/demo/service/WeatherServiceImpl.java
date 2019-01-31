package com.demo.service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.exceptionhandler.WeatherNotFoundException;
import com.demo.model.Weather;
import com.demo.repository.WeatherRepository;
import com.example.demo.bean.WeatherModel;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private WeatherRepository weatherRepository;

	public Weather createWeather(Weather weather) {
		return weatherRepository.save(weather);
	}

	public Optional<Weather> getWeatherByID(Long id) {

		if (!isExist(id)) {
			throw new WeatherNotFoundException();
		}
		return this.weatherRepository.findById(id);
	}

	public List<Weather> getWeatherBySiteID(String siteid) {

		Date date = new Date();
		Instant instant3 = date.toInstant();
		Date newDate = Date.from(instant3.minusSeconds(60 * 24 * 60));

		
		return this.weatherRepository.findAllWithCreationDateTimeAfter(newDate, siteid);
	}

	public List<Weather> getWeather() {
		return this.weatherRepository.findAll();
	}

	public Weather updateWeather(Weather weather, Long id) {

		if (!isExist(id)) {
			throw new WeatherNotFoundException();
		}
		weather.setWeatherID(id);
		return weatherRepository.save(weather);
	}

	public void deleteWeather(Long id) {
		
		if (!isExist(id)) {
			throw new WeatherNotFoundException();
		}
		this.weatherRepository.deleteById(id);
	}

	@KafkaListener(topics = "test1", containerFactory = "greetingKafkaListenerContainerFactory")
	public void greetingListener(WeatherModel question) {
		System.out.println("yeeeee" + question.toString());
		saveData(question);

	}

	private void saveData(WeatherModel question) {
		Weather entity = new Weather();
		entity.setHumidity(question.getHumidity());
		entity.setCreatedate(question.getCreatedate());
		entity.setSiteid(question.getSiteid());
		entity.setWindspeed(question.getWindspeed());
		entity.setTemperature(question.getTemperature());

		this.createWeather(entity);

	}

	public Boolean isExist(Long id) {
		Optional<Weather> weather = this.weatherRepository.findById(id);

		if (!weather.isPresent())
			return false;

		return true;
	}

}

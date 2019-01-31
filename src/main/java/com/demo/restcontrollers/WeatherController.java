/**
 * 
 */
package com.demo.restcontrollers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Weather;
import com.demo.service.WeatherServiceImpl;

@RestController
@RequestMapping("api/v1/")

public class WeatherController {

	@Autowired
	private WeatherServiceImpl weatherServiceImpl;

	@GetMapping("/")
	public String echoTheUsersEmailAddress(Principal principal) {
		return "Hey there! Your email address is: " + principal.getName();
	}

	// POST
	@RequestMapping(value = "weather", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Weather create(@RequestBody Weather question) {
		return weatherServiceImpl.createWeather(question);
	}

	// GET BY ID
	@RequestMapping(value = "weather/{id}", method = RequestMethod.GET)
	public Optional<Weather> get(@PathVariable Long id) {
		return weatherServiceImpl.getWeatherByID(id);

	}

	// GET BY SITEID - 24 HR DATA
	@RequestMapping(value = "weather24/{siteid}", method = RequestMethod.GET)
	public List<Weather> get24hrData(@PathVariable String siteid) {
		return weatherServiceImpl.getWeatherBySiteID(siteid);
	}

	// GET ALL DATA
	@RequestMapping(value = "weather", method = RequestMethod.GET)
	public List<Weather> getWeatherData() {
		return weatherServiceImpl.getWeather();
	}

	// UPDATE DATA - PUT
	@RequestMapping(value = "weather/{id}", method = RequestMethod.PUT)
	public Weather updateQuestionAnswer(@PathVariable Long id, @RequestBody Weather weather) {
		return this.weatherServiceImpl.updateWeather(weather, id);
	}

	// DELETE
	@RequestMapping(value = "weather/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		this.weatherServiceImpl.deleteWeather(id);
	}
//
//	// update partially
//	@RequestMapping(value = "questions/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PATCH)
//	public Weather updateQuestionAnswerPartially(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
//
//		if (!isExist(id)) {
//			throw new QuestionNotFoundException();
//		}
//
//		Optional<Weather> questionOpt = weatherRepository.findById(id);
//		Weather ques = questionOpt.get();
//		// Map key is field name, v is value
//		fields.forEach((k, v) -> {
//			// use reflection to get field k on manager and set it to value k
//			Field field = ReflectionUtils.findRequiredField(Weather.class, k);
//			ReflectionUtils.setField(field, ques, v);
//		});
//
//		ques.setWeatherID(id);
//		return this.weatherRepository.save(ques);
//
//	}
//

}
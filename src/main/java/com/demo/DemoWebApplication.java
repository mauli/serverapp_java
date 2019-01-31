package com.demo;

import java.security.Principal;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.demo.restcontrollers.WelcomeController;

@RestController
@SpringBootApplication
//@EnableWebMvc
public class DemoWebApplication{

	public static void main(String[] args) {
		SpringApplication.run(DemoWebApplication.class, args);
	}

	@GetMapping("/")
	public String echoTheUsersEmailAddress(Principal principal) throws JSONException {
		
		//WelcomeController restfulClient = new WelcomeController();

		//restfulClient.postEntity();
		return "Hey there! Your email address is: " + principal.getName();
	   
	}
}


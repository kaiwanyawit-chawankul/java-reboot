package com.example.mvc.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController2 {

	private final GreetingService service;

	public GreetingController2(GreetingService service) {
		this.service = service;
	}

	@RequestMapping("/greeting2")
	public @ResponseBody String greeting() {
		return service.greet();
	}

}

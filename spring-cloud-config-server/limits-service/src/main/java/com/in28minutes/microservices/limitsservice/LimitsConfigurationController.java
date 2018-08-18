package com.in28minutes.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
	@Autowired
	Configuration config;
	
	@GetMapping("/limits")
	public LimitConfiguration getLimits(){
		return new LimitConfiguration(config.getMaximum(),config.getMinimum());
	}

}

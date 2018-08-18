package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	@Autowired
	Environment env;
	@Autowired
	CurrencyExchangeRepository repository;
	
	@GetMapping("/currency_exchange/from/{from}/to/{to}")
	public CurrencyExchange getCurrencyExchangeValue(@PathVariable String from,@PathVariable String to){
		
		
		CurrencyExchange currencyExchange=repository.findByToAndFrom(to, from);
	
		currencyExchange.setPort(Integer.parseInt(env.getProperty("local.server.port")));	
		return currencyExchange;
	}

}

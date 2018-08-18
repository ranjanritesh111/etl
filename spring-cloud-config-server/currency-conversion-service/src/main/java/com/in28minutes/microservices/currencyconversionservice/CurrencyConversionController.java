package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	@Autowired
	CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyconversionBean convertCurrency(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity){
		
		Map<String,String> uriVariable=new HashMap<String,String>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		
		
		ResponseEntity<CurrencyconversionBean> responseEntity=new RestTemplate().getForEntity("http://localhost:8000/currency_exchange/from/{from}/to/{to}", CurrencyconversionBean.class,uriVariable);
		
		CurrencyconversionBean response=responseEntity.getBody();
		CurrencyconversionBean bean=new CurrencyconversionBean();
		bean.setId(response.getId());
		bean.setExchangeMultiple(response.getExchangeMultiple());
		bean.setQuantity(quantity);
		bean.setFrom(from);
		bean.setTo(to);
		bean.setTotalAmount(response.getExchangeMultiple().multiply(quantity));
		bean.setPort(response.getPort());
		return bean;
		
	}
@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")	
public CurrencyconversionBean convertCurrencyFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity){
		
		
		CurrencyconversionBean response=proxy.retrieveExchangeValue(from, to);
		CurrencyconversionBean bean=new CurrencyconversionBean();
		bean.setId(response.getId());
		bean.setExchangeMultiple(response.getExchangeMultiple());
		bean.setQuantity(quantity);
		bean.setFrom(from);
		bean.setTo(to);
		bean.setTotalAmount(response.getExchangeMultiple().multiply(quantity));
		bean.setPort(response.getPort());
		return bean;
		
	}

}

package com.in28minutes.microservices.currencyexchangeservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchange {
	@Id
	private long id;
	private int port;
	
	@Column(name="currency_from")
	private String from;
	
	@Column(name="currency_to")
	private String to;
	
	private int exchangeMultiple;
	
	public CurrencyExchange() {
		
	}
	
	public CurrencyExchange(long id, String from, String to, int exchangeMultiple) {
		super();
		this.id = id;
		
		this.from = from;
		this.to = to;
		this.exchangeMultiple = exchangeMultiple;
	}
	public long getId() {
		return id;
	}
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public int getExchangeMultiple() {
		return exchangeMultiple;
	}
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}

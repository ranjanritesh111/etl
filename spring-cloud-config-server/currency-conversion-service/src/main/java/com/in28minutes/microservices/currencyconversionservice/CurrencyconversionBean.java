package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyconversionBean {
	private Long id;
	private String from;
	private String to;
	private BigDecimal quantity;
	private BigDecimal totalAmount;
	private BigDecimal exchangeMultiple;
	int port;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public BigDecimal getExchangeMultiple() {
		return exchangeMultiple;
	}
	public void setExchangeMultiple(BigDecimal exchangeMultiple) {
		this.exchangeMultiple = exchangeMultiple;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	

}

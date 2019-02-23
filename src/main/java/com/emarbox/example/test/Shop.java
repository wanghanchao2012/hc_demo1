package com.emarbox.example.test;

public class Shop {

	public Shop(String name) {
		super();
		this.name = name;
	}

	private String name;
	private Double price = 1D;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice(String BestPrice) {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}

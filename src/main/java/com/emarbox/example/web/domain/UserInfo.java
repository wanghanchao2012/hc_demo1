package com.emarbox.example.web.domain;

public class UserInfo {
	private String account;
	private String name;
	private Double amount;

	public UserInfo() {
		super();
	}

	public UserInfo(String account, String name, Double amount) {
		super();
		this.account = account;
		this.name = name;
		this.amount = amount;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}

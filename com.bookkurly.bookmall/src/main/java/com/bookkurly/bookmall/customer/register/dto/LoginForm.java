package com.bookkurly.bookmall.customer.register.dto;

import com.bookkurly.bookmall.customer.register.entity.Customer;

public class LoginForm {

	private String customId;
	private String customPw;

	public String getCustomId() {
		return customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	public String getCustomPw() {
		return customPw;
	}

	public void setCustomPw(String customPw) {
		this.customPw = customPw;
	}

	public LoginForm(String customId, String customPw) {
		super();
		this.customId = customId;
		this.customPw = customPw;
	}

	@Override
	public String toString() {
		return "LoginForm [customId=" + customId + ", customPw=" + customPw + "]";
	}

	public Customer toEntity() {
		return Customer.builder()
				.customId(customId)
				.customPw(customPw)
				.build();
	}

}

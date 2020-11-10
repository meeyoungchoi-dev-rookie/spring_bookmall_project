package com.bookkurly.bookmall.customer.register.entity;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
public class Customer {

	private String customId;
	private String customPw;
	
	
	
	
	
	@Builder
	public Customer( String customId, String customPw) {
		this.customId = customId;
		this.customPw = customPw;
	}


	@Override
	public String toString() {
		return "Login [customId=" + customId + ", customPw=" + customPw + "]";
	}


	public Customer() {
		super();
	}

	
	
	
	

}

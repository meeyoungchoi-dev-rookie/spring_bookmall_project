package com.bookkurly.bookmall.customer.register.service;

import com.bookkurly.bookmall.customer.jang.dto.PaymentForm;
import com.bookkurly.bookmall.customer.register.entity.Customer;

public interface CustomerService {
	public Customer checkLogin(Customer login);
	
	public void regist(Customer regist);
	
	public Integer selectCustomerSeq(String customId);
	
	public Integer updateCustomInfo(PaymentForm paymentForm);

	public String findCustomerName(Integer customSeq);

}

package com.bookkurly.bookmall.customer.register.dao;

import com.bookkurly.bookmall.customer.jang.dto.PaymentForm;
import com.bookkurly.bookmall.customer.register.entity.Customer;

public interface CustomerDAO {

	Customer checkLogin(Customer login);

	void regist(Customer regist);

	Integer selectCustomerSeq(String customId);

	Integer updateCustomInfo(PaymentForm paymentForm);

	String findCustomerName(Integer customSeq);
}

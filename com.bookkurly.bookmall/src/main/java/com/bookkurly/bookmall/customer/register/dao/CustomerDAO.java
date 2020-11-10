package com.bookkurly.bookmall.customer.register.dao;

import com.bookkurly.bookmall.customer.register.entity.Customer;

public interface CustomerDAO {

	Customer checkLogin(Customer login);

	void regist(Customer regist);
}

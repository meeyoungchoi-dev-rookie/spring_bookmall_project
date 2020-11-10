package com.bookkurly.bookmall.customer.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookkurly.bookmall.customer.register.dao.CustomerDAO;
import com.bookkurly.bookmall.customer.register.entity.Customer;

@Service
public class CustomerServiceImpl {

	@Autowired
	private CustomerDAO customerDao;
	
	
	public Customer checkLogin(Customer login) {
		System.out.println("a");
		return customerDao.checkLogin(login);
		
	}

}

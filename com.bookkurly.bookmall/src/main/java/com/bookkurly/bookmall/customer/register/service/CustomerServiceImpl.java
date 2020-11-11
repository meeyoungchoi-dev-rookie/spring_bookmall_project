package com.bookkurly.bookmall.customer.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookkurly.bookmall.customer.register.dao.CustomerDAO;
import com.bookkurly.bookmall.customer.register.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;

	@Override
	public void regist(Customer regist) {
		customerDao.regist(regist);

	}

	@Override
	public Customer checkLogin(Customer login) {
		return customerDao.checkLogin(login);
	}

	@Override
	public Integer selectCustomerSeq(String userId) {
		return customerDao.selectCustomerSeq(userId);
		
	}


}

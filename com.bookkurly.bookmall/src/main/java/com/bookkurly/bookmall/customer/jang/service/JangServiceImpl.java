package com.bookkurly.bookmall.customer.jang.service;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookkurly.bookmall.customer.jang.dao.JangDAO;
import com.bookkurly.bookmall.customer.jang.dto.JangDeleteInfo;
import com.bookkurly.bookmall.customer.jang.dto.JangInfo;
import com.bookkurly.bookmall.customer.jang.dto.JangUpdate;
import com.bookkurly.bookmall.customer.jang.dto.OrderDetail;
import com.bookkurly.bookmall.customer.jang.entity.JangEntity;

@Service
public class JangServiceImpl implements JangService {

	@Autowired
	private JangDAO jangDao;
	
	
	
	@Override
	public String createJangSerialNum() {
		System.out.println("createNum");
		
		Calendar cal  = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		System.out.println("year: " + year);
		
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		System.out.println("ym: " + ym);
		
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		System.out.println("ymd: " + ymd);
	
		String subNum = "";
		
		for (int i = 1; i <= 6; i++) {
			subNum += (int)(Math.random() * 10);
		}
		
		
		String jangId = ymd + "_" + subNum;
		
		return jangId;
	}

	@Override
	public void insertToJang(JangEntity entity) {
		
		jangDao.insertToJang(entity);
	}

	@Override
	public List<JangEntity> getCustomerJangList(JangInfo jangInfo) {
		return jangDao.getCustomerJangList(jangInfo);
	}

	@Override
	public Integer updateOrder(JangUpdate jangUpdate) {
		return jangDao.updateOrder(jangUpdate);
	}

	@Override
	public JangEntity selectJangByBookSeqOrderSerialNum(JangUpdate jangUpdate) {
		return jangDao.selectJangByBookSeqOrderSerialNum(jangUpdate);
	}

	@Override
	public Integer deleteJangItem(JangDeleteInfo jangDelete) {
		return jangDao.deleteJangItem(jangDelete);
	}

	@Override
	public Integer deleteJang(String myOrderSerialNum) {
		return jangDao.deleteJang(myOrderSerialNum);
	}

	@Override
	public List<JangEntity> selectAll(String myOrderSerialNum) {
		return jangDao.selectAll(myOrderSerialNum);
	}

	@Override
	public Integer updateOrderStatement(String myOrderSerialNum) {
		return jangDao.updateOrderStatement(myOrderSerialNum);
	}

	@Override
	public JangEntity selectOrderDetail(OrderDetail orderDetail) {
		return jangDao.selectOrderDetail(orderDetail);
	}

	public JangEntity findJangInfo(JangEntity jangEntity) {
		return jangDao.findJangInfo(jangEntity);
	}

	
	
	
	
	
	

	
	

	

	
	
	




}

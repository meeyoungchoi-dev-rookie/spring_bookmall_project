package com.bookkurly.bookmall.admin.adimaccount.dto;

import com.bookkurly.bookmall.admin.adimaccount.entity.BookMallManager;

public class BookMallManagerForm {

	private String adminId;
	private String adminPw;
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	public BookMallManagerForm(String adminId, String adminPw) {
		super();
		this.adminId = adminId;
		this.adminPw = adminPw;
	}
	@Override
	public String toString() {
		return "AdminForm [adminId=" + adminId + ", adminPw=" + adminPw + "]";
	}
	public BookMallManager toEntity() {
		return BookMallManager.builder().adminId(adminId).adminPw(adminPw).build();
		
	}

	
}

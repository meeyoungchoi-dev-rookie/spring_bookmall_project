package com.bookkurly.bookmall.admin.adimaccount.dto;

import com.bookkurly.bookmall.admin.adimaccount.entity.AdminMainCategory;
import com.bookkurly.bookmall.customer.category.entity.MainCategory;
import com.bookkurly.bookmall.customer.jang.entity.JangEntity;

public class AdminMainCategoryForm {
	private String mainCateName;

	public String getMainCateName() {
		return mainCateName;
	}

	public void setMainCateName(String mainCateName) {
		this.mainCateName = mainCateName;
	}

	public AdminMainCategoryForm(String mainCateName) {
		super();
		this.mainCateName = mainCateName;
	}

	@Override
	public String toString() {
		return "MainCategory [mainCateName=" + mainCateName + "]";
	}

	public AdminMainCategory toEntity() {
		return AdminMainCategory.builder().mainCateName(mainCateName).build();
	}

}

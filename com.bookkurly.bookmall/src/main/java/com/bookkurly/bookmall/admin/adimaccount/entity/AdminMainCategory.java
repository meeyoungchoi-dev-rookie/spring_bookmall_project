package com.bookkurly.bookmall.admin.adimaccount.entity;

import javax.persistence.Entity;

import lombok.Builder;

@Entity
public class AdminMainCategory {

	private Integer mainCateSeq;
	private String mainCateName;

	public Integer getMainCateSeq() {
		return mainCateSeq;
	}

	public void setMainCateSeq(Integer mainCateSeq) {
		this.mainCateSeq = mainCateSeq;
	}

	public String getMainCateName() {
		return mainCateName;
	}

	public void setMainCateName(String mainCateName) {
		this.mainCateName = mainCateName;
	}

	@Builder
	public AdminMainCategory(Integer mainCateSeq, String mainCateName) {
		this.mainCateSeq = mainCateSeq;
		this.mainCateName = mainCateName;
	}

	@Override
	public String toString() {
		return "MainCategory [mainCateSeq=" + mainCateSeq + ", mainCateName=" + mainCateName + "]";
	}

}

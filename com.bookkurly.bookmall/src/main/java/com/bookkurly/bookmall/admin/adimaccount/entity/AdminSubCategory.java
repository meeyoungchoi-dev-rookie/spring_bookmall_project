package com.bookkurly.bookmall.admin.adimaccount.entity;

import javax.persistence.Entity;

import lombok.Builder;

@Entity
public class AdminSubCategory {
	private Integer subCateSeq;
	private Integer mainCateSeq;
	private String subCateName;
	private Integer subCateBookCount;

	public Integer getSubCateSeq() {
		return subCateSeq;
	}

	public void setSubCateSeq(Integer subCateSeq) {
		this.subCateSeq = subCateSeq;
	}

	public Integer getMainCateSeq() {
		return mainCateSeq;
	}

	public void setMainCateSeq(Integer mainCateSeq) {
		this.mainCateSeq = mainCateSeq;
	}

	public String getSubCateName() {
		return subCateName;
	}

	public void setSubCateName(String subCateName) {
		this.subCateName = subCateName;
	}

	public Integer getSubCateBookCount() {
		return subCateBookCount;
	}

	public void setSubCateBookCount(Integer subCateBookCount) {
		this.subCateBookCount = subCateBookCount;
	}

	@Builder
	public AdminSubCategory(Integer subCateSeq, Integer mainCateSeq, String subCateName, Integer subCateBookCount) {
		super();
		this.subCateSeq = subCateSeq;
		this.mainCateSeq = mainCateSeq;
		this.subCateName = subCateName;
		this.subCateBookCount = subCateBookCount;
	}

	@Override
	public String toString() {
		return "AdminSubCategory [subCateSeq=" + subCateSeq + ", mainCateSeq=" + mainCateSeq + ", subCateName="
				+ subCateName + ", subCateBookCount=" + subCateBookCount + "]";
	}

	

}

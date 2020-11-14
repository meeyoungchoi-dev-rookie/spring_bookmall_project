package com.bookkurly.bookmall.customer.category.entity;

public class SubCategory {
	private Integer subCateSeq;
	private Integer mainCateSeq;
	private String subCateName;
	private Integer subCateBookCount;

	public Integer getSubCateBookCount() {
		return subCateBookCount;
	}

	public void setSubCateBookCount(Integer subCateBookCount) {
		this.subCateBookCount = subCateBookCount;
	}

	public Integer getMainCateSeq() {
		return mainCateSeq;
	}

	public void setMainCateSeq(Integer mainCateSeq) {
		this.mainCateSeq = mainCateSeq;
	}

	public Integer getSubCateSeq() {
		return subCateSeq;
	}

	public void setSubCateSeq(Integer subCateSeq) {
		this.subCateSeq = subCateSeq;
	}

	public String getSubCateName() {
		return subCateName;
	}

	public void setSubCateName(String subCateName) {
		this.subCateName = subCateName;
	}

	public SubCategory() {
		super();
	}

	public SubCategory(Integer subCateSeq, Integer mainCateSeq, String subCateName, Integer subCateBookCount) {
		super();
		this.subCateSeq = subCateSeq;
		this.mainCateSeq = mainCateSeq;
		this.subCateName = subCateName;
		this.subCateBookCount = subCateBookCount;
	}

	@Override
	public String toString() {
		return "SubCategory [subCateSeq=" + subCateSeq + ", mainCateSeq=" + mainCateSeq + ", subCateName=" + subCateName
				+ ", subCateBookCount=" + subCateBookCount + "]";
	}

}

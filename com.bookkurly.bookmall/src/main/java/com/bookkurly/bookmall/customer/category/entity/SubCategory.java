package com.bookkurly.bookmall.customer.category.entity;

public class SubCategory {
	private Integer subCateSeq;
	private Integer mainCateSeq;
	private String subCateName;
	
	
	
	
	
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

	public SubCategory(Integer subCateSeq, Integer mainCateSeq, String subCateName) {
		super();
		this.subCateSeq = subCateSeq;
		this.mainCateSeq = mainCateSeq;
		this.subCateName = subCateName;
	}
	@Override
	public String toString() {
		return "SubCategory [subCateSeq=" + subCateSeq + ", mainCateSeq=" + mainCateSeq + ", subCateName=" + subCateName
				+ "]";
	}


	
	
	
	
	
	
	
	
	

}

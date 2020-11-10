package com.bookkurly.bookmall.customer.category.entity;

public class MainCategory {
	
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
	public MainCategory() {
		super();
	}
	public MainCategory(Integer mainCateSeq, String mainCateName) {
		super();
		this.mainCateSeq = mainCateSeq;
		this.mainCateName = mainCateName;
	}
	@Override
	public String toString() {
		return "MainCategory [mainCateSeq=" + mainCateSeq + ", mainCateName=" + mainCateName + "]";
	}
	
	
	
	

}

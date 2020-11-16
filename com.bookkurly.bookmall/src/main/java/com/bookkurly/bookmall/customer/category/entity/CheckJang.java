package com.bookkurly.bookmall.customer.category.entity;

public class CheckJang {
	private Integer customSeq;
	private Integer bookSeq;

	public Integer getCustomSeq() {
		return customSeq;
	}

	public void setCustomSeq(Integer customSeq) {
		this.customSeq = customSeq;
	}

	public Integer getBookSeq() {
		return bookSeq;
	}

	public void setBookSeq(Integer bookSeq) {
		this.bookSeq = bookSeq;
	}

	public CheckJang(Integer customSeq, Integer bookSeq) {
		super();
		this.customSeq = customSeq;
		this.bookSeq = bookSeq;
	}

	public CheckJang() {
		super();
	}

	@Override
	public String toString() {
		return "CheckJang [customSeq=" + customSeq + ", bookSeq=" + bookSeq + "]";
	}

}

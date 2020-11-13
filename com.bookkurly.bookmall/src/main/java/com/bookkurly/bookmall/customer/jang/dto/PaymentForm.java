package com.bookkurly.bookmall.customer.jang.dto;

public class PaymentForm {
	private Integer customSeq;
	private String customId;
	private String customName;
	private String customAddr;
	private String customPhoneNumber;

	public Integer getCustomSeq() {
		return customSeq;
	}

	public void setCustomSeq(Integer customSeq) {
		this.customSeq = customSeq;
	}

	public String getCustomId() {
		return customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getCustomAddr() {
		return customAddr;
	}

	public void setCustomAddr(String customAddr) {
		this.customAddr = customAddr;
	}

	public String getCustomPhoneNumber() {
		return customPhoneNumber;
	}

	public void setCustomPhoneNumber(String customPhoneNumber) {
		this.customPhoneNumber = customPhoneNumber;
	}

	public PaymentForm(Integer customSeq, String customId, String customName, String customAddr,
			String customPhoneNumber) {
		super();
		this.customSeq = customSeq;
		this.customId = customId;
		this.customName = customName;
		this.customAddr = customAddr;
		this.customPhoneNumber = customPhoneNumber;
	}

	@Override
	public String toString() {
		return "PaymentForm [customSeq=" + customSeq + ", customId=" + customId + ", customName=" + customName
				+ ", customAddr=" + customAddr + ", customPhoneNumber=" + customPhoneNumber + "]";
	}

}

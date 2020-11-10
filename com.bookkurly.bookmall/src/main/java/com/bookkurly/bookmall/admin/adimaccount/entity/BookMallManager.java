package com.bookkurly.bookmall.admin.adimaccount.entity;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
public class BookMallManager {
	
	private Integer adminSeq;
	private String adminId;
	private String adminPw;
	
	@Builder
	public BookMallManager(Integer adminSeq, String adminId, String adminPw) {
		super();
		this.adminSeq = 0;
		this.adminId = adminId;
		this.adminPw = adminPw;
	}

	@Override
	public String toString() {
		return "BookMallManager [adminSeq=" + adminSeq + ", adminId=" + adminId + ", adminPw=" + adminPw + "]";
	}

	public BookMallManager() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

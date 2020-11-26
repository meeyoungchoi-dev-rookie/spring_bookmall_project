package com.bookkurly.bookmall.customer.category.entity;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Book {
	private Integer bookSeq;
	private String bookTitle;
	private String bookIntro;
	private String bookContents;
	private int bookPrice;
	private int bookAmount;
	private Integer subCateSeq;
	private String bookStatus;
	private String subCateName;
	private String bookDescription;
	private String bookImageName;


	@Builder
	public Book(Integer bookSeq, String bookTitle, String bookIntro, String bookContents, int bookPrice, int bookAmount,
			Integer subCateSeq, String bookStatus, String subCateName, String bookDescription, String bookImageName) {
		super();
		this.bookSeq = bookSeq;
		this.bookTitle = bookTitle;
		this.bookIntro = bookIntro;
		this.bookContents = bookContents;
		this.bookPrice = bookPrice;
		this.bookAmount = bookAmount;
		this.subCateSeq = subCateSeq;
		this.bookStatus = bookStatus;
		this.subCateName = subCateName;
		this.bookDescription = bookDescription;
		this.bookImageName = bookImageName;
	}

	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "Book [bookSeq=" + bookSeq + ", bookTitle=" + bookTitle + ", bookIntro=" + bookIntro + ", bookContents="
				+ bookContents + ", bookPrice=" + bookPrice + ", bookAmount=" + bookAmount + ", subCateSeq="
				+ subCateSeq + ", bookStatus=" + bookStatus +  ", bookDescription="
				+ bookDescription + ", bookImageName=" + bookImageName + "]";
	}

}

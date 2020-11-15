package com.bookkurly.bookmall.customer.category.dto;

import org.springframework.web.multipart.MultipartFile;

import com.bookkurly.bookmall.customer.category.entity.Book;

//웹에서 넘어오는 값 저장 
public class BookDTO {

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
	private MultipartFile bookImageName;

	public Integer getBookSeq() {
		return bookSeq;
	}

	public void setBookSeq(Integer bookSeq) {
		this.bookSeq = bookSeq;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookIntro() {
		return bookIntro;
	}

	public void setBookIntro(String bookIntro) {
		this.bookIntro = bookIntro;
	}

	public String getBookContents() {
		return bookContents;
	}

	public void setBookContents(String bookContents) {
		this.bookContents = bookContents;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getBookAmount() {
		return bookAmount;
	}

	public void setBookAmount(int bookAmount) {
		this.bookAmount = bookAmount;
	}

	public Integer getSubCateSeq() {
		return subCateSeq;
	}

	public void setSubCateSeq(Integer subCateSeq) {
		this.subCateSeq = subCateSeq;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public String getSubCateName() {
		return subCateName;
	}

	public void setSubCateName(String subCateName) {
		this.subCateName = subCateName;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public MultipartFile getBookImageName() {
		return bookImageName;
	}

	public void setBookImageName(MultipartFile bookImageName) {
		this.bookImageName = bookImageName;
	}

	public BookDTO(Integer bookSeq, String bookTitle, String bookIntro, String bookContents, int bookPrice, int bookAmount,
			Integer subCateSeq, String bookStatus, String subCateName, String bookDescription,
			MultipartFile bookImageName) {
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
	
	
	public Book toEntity(Integer bookSeq, String originalFileName) {
		return Book.builder()
				.bookSeq(bookSeq)
				.bookTitle(bookTitle)
				.bookIntro(bookIntro)
				.bookContents(bookContents)
				.bookPrice(bookPrice)
				.bookAmount(bookAmount)
				.subCateSeq(subCateSeq)
				.bookStatus(bookStatus)
				.subCateName(subCateName)
				.bookDescription(bookDescription)
				.bookImageName(originalFileName)
				.build();
	}
	
	

	@Override
	public String toString() {
		return "Book [bookSeq=" + bookSeq + ", bookTitle=" + bookTitle + ", bookIntro=" + bookIntro + ", bookContents="
				+ bookContents + ", bookPrice=" + bookPrice + ", bookAmount=" + bookAmount + ", subCateSeq="
				+ subCateSeq + ", bookStatus=" + bookStatus + ", subCateName=" + subCateName + ", bookDescription="
				+ bookDescription + ", bookImageName=" + bookImageName + "]";
	}

}

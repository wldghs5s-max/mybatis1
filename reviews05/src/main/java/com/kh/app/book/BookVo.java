package com.kh.app.book;

public class BookVo {
	
	private String no;
	private String title;
	private String price;
	private String createdAt;
	private String updatedAt;
	private String rentalYn;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getRentalYn() {
		return rentalYn;
	}
	public void setRentalYn(String rentalYn) {
		this.rentalYn = rentalYn;
	}
	public BookVo(String no, String title, String price, String createdAt, String updatedAt, String rentalYn) {
		super();
		this.no = no;
		this.title = title;
		this.price = price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.rentalYn = rentalYn;
	}
	public BookVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", price=" + price + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", rentalYn=" + rentalYn + "]";
	}
	
	
	

}

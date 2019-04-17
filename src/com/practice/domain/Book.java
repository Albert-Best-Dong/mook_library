package com.practice.domain;
/**
* 	Book的实体类
* 	@author Albert
*
*/
public class Book {
	private String bookID;	//图书ID
	private String bookName;	//图书名
	private String catgoryName;	//图书分类名
	private String price;	//图书价格
	private String description;	//描述

	public Book() {

	}
	public Book(String bookID, String bookName, String catgoryName, String price, String description) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.catgoryName = catgoryName;
		this.price = price;
		this.description = description;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getCatgoryName() {
		return catgoryName;
	}
	public void setCatgoryName(String catgoryName) {
		this.catgoryName = catgoryName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Book [图书bookID=" + bookID + ", 图书名=" + bookName + ", 图书分类名=" + catgoryName + ", 价格=" + price
				+ ", 描述=" + description + "]";
	}


}

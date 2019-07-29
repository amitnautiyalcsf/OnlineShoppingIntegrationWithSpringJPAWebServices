package com.abc.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


public class Card 
{
	
	private int id;
	private String cardNo;
	private String name;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date expiry;
	private int cvv;
	private int itemId;
	private long mobile;
	private int quantity;
	
	public Card() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Card(int id, String cardNo, String name, Date expiry, int cvv, int itemId) {
		super();
		this.id = id;
		this.cardNo = cardNo;
		this.name = name;
		this.expiry = expiry;
		this.cvv = cvv;
		this.itemId = itemId;
	}
	
	



	public Card(int id, String cardNo, String name, Date expiry, int cvv, int itemId, long mobile, int quantity) {
		super();
		this.id = id;
		this.cardNo = cardNo;
		this.name = name;
		this.expiry = expiry;
		this.cvv = cvv;
		this.itemId = itemId;
		this.mobile = mobile;
		this.quantity = quantity;
	}



	
	@Override
	public String toString() {
		return "Card [id=" + id + ", cardNo=" + cardNo + ", name=" + name + ", expiry=" + expiry + ", cvv=" + cvv
				+ ", itemId=" + itemId + ", mobile=" + mobile + ", quantity=" + quantity + "]";
	}



	public final int getId() {
		return id;
	}
	public final void setId(int id) {
		this.id = id;
	}
	public final String getCardNo() {
		return cardNo;
	}
	public final void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final Date getExpiry() {
		return expiry;
	}
	public final void setExpiry(Date expiry) {
		this.expiry = expiry;
	}
	public final int getCvv() {
		return cvv;
	}
	public final void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public final int getItemId() {
		return itemId;
	}
	public final void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public final long getMobile() {
		return mobile;
	}
	public final void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public final int getQuantity() {
		return quantity;
	}
	public final void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}

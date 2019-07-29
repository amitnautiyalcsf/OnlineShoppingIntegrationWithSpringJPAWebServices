package com.abc.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name="order_hib")
public class Order 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String custName;
	private long custMobile;
	private int itemId;
	private int quantity;
	
	@Column(name="purchase_date")
	private Date purchaseDate;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int id, String custName, long custMobile, int itemId, int quantity, Date purchaseDate) {
		super();
		this.id = id;
		this.custName = custName;
		this.custMobile = custMobile;
		this.itemId = itemId;
		this.quantity = quantity;
		this.purchaseDate = purchaseDate;
	}

	
	
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", custName=" + custName + ", custMobile=" + custMobile + ", itemId=" + itemId
				+ ", quantity=" + quantity + ", purchaseDate=" + purchaseDate + "]";
	}

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getCustName() {
		return custName;
	}

	public final void setCustName(String custName) {
		this.custName = custName;
	}

	public final long getCustMobile() {
		return custMobile;
	}

	public final void setCustMobile(long custMobile) {
		this.custMobile = custMobile;
	}

	public final int getItemId() {
		return itemId;
	}

	public final void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public final int getQuantity() {
		return quantity;
	}

	public final void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public final Date getPurchaseDate() {
		return purchaseDate;
	}

	public final void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	

}

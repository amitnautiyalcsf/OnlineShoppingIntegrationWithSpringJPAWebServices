package com.abc.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
@Entity
@Table(name="item_hib")
public class Item 
{
	@Id
	private int id;
	private String name;
	private double price;
	private String category;
	private int quantity;
	public Item() {
		
		
	}
	public Item(int id, String name, double price, String category, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", quantity="
				+ quantity + "]";
	}
	public final int getId() {
		return id;
	}
	public final void setId(int id) {
		this.id = id;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final double getPrice() {
		return price;
	}
	public final void setPrice(double price) {
		this.price = price;
	}
	public final String getCategory() {
		return category;
	}
	public final void setCategory(String category) {
		this.category = category;
	}
	public final int getQuantity() {
		return quantity;
	}
	public final void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}

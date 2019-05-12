package com.rishi.mockito.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Item {

	@Id //indicate the primary key
	private int id;
	private String name;
	private int price;
	private int quantity;

	@Transient //we don't want to store this field to a database.
	private int value; // at a later stage we might want to create a business logic.
	
	protected Item() {
		
	}
	public Item(int id, String name, int price, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String toString() {
		return String.format("Item[%d, %s, %d, %d]", id, name, price, quantity);
	}

}

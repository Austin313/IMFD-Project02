package com.project2.imfd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Orderitem {
	
	@Id
	int orderno;
	@Id
	int itemno;
	int quantity;
	public Orderitem() {
		super();
	}
	public Orderitem(int orderno, int itemno, int quantity) {
		super();
		this.orderno = orderno;
		this.itemno = itemno;
		this.quantity = quantity;
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public int getItemno() {
		return itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Orderitem [orderno=" + orderno + ", itemno=" + itemno + ", quantity=" + quantity + "]";
	}

	
}

package com.project2.imfd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ShoppingCart {
	@Id
	@GeneratedValue
	private Integer cartId;
	private int customerId;
	private int productId;
	private int productQuanity;
	private float price;
	private String productName;
	
	public ShoppingCart(int customerId, int productId, int productQuanity, float price, String productName) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.productQuanity = productQuanity;
		this.price = price;
		this.productName = productName;
	}
	
	
	
}

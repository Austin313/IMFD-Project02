package com.project2.imfd.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer implements Serializable{
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer customer_id;
	private String firstname;
	private String lastname;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false)
	private String phoneno;
	private String username;
	private String password;
	/**
	 * @param customer_id
	 * @param firstname
	 * @param lastname
	 * @param address
	 * @param phoneno
	 * @param username
	 * @param password
	 */
	public Customer(Integer customer_id, String firstname, String lastname, String address, String phoneno,
			String username, String password) {
		super();
		this.customer_id = customer_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phoneno = phoneno;
		this.username = username;
		this.password = password;
	}
	
	/*
	 * public Customer(String firstname, String lastname, String address, String
	 * phoneno) { super(); this.firstname = firstname; this.lastname = lastname;
	 * this.address = address; this.phoneno = phoneno; }
	 */
	
	

}
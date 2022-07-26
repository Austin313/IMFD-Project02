package com.project2.imfd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customer_id;
	private String firstname;
	private String lastname;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false)
	private String phoneno;
	public Customer() {
		super();
	}
	public Customer(String firstname, String lastname, String address, String phoneno) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phoneno = phoneno;
	}
	public Customer(int customer_id, String firstname, String lastname, String address, String phoneno) {
		super();
		this.customer_id = customer_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phoneno = phoneno;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address
				+ ", phoneno=" + phoneno + "]";
	}
	
	

}
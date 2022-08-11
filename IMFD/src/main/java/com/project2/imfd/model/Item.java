package com.project2.imfd.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Item implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer itemno;
private String itemname;
private String itemType;
private float itemPrice;
private int stock = 100;

public Item(Integer itemno, String itemname, String itemType, float itemPrice) {
	super();
	this.itemno = itemno;
	this.itemname = itemname;
	this.itemType = itemType;
	this.itemPrice = itemPrice;
}



}

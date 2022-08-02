package com.project2.imfd.model;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
Integer itemno;
String itemname;
String itemType;
float itemPrice;

public Item(Integer itemno, String itemname, String itemType, float itemPrice) {
	super();
	this.itemno = itemno;
	this.itemname = itemname;
	this.itemType = itemType;
	this.itemPrice = itemPrice;
}



}

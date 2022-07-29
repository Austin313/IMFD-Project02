package com.project2.imfd.model;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@SuppressWarnings("serial")
@Entity
public class Item implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
Integer itemno;

int itemname;
public Item() {
	super();
}

public Item(int itemname) {
	super();
	this.itemname = itemname;
}

public Item(int itemno, int itemname) {
	super();
	this.itemno = itemno;
	this.itemname = itemname;
}

public int getItemno() {
	return itemno;
}
public void setItemno(int itemno) {
	this.itemno = itemno;
}
public int getItemname() {
	return itemname;
}
public void setItemname(int itemname) {
	this.itemname = itemname;
}


}

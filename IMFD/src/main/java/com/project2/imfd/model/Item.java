package com.project2.imfd.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
int itemno;
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

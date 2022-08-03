package com.project2.imfd.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderItem implements Serializable {
	
	@EmbeddedId
	OrderItemKey id;
	
	@ManyToOne
	@MapsId("orderNo")
	@JoinColumn(name="orderno")
	OrderDetail orderDetail;
	
	@ManyToOne
	@MapsId("itemNo")
	@JoinColumn(name="itemno")
	Item item;
	
	
	int quantity;
	

	
}

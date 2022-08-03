package com.project2.imfd.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class OrderItemKey implements Serializable{
	@Column(name="orderno")
	Integer orderNo;
	
	@Column(name="itemno")
	Integer itemNo;

	@Override
	public int hashCode() {
		return Objects.hash(itemNo, orderNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemKey other = (OrderItemKey) obj;
		return Objects.equals(itemNo, other.itemNo) && Objects.equals(orderNo, other.orderNo);
	}

	public OrderItemKey(Integer orderNo, Integer itemNo) {
		super();
		this.orderNo = orderNo;
		this.itemNo = itemNo;
	}

}

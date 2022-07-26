package com.project2.imfd.dao;

import antlr.collections.List;

public interface OrderDao {
	List getOrders();
	List getOrdersById(String id);
}

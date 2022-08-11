package com.project2.imfd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project2.imfd.exceptions.ProductNotFound;
import com.project2.imfd.model.Item;
import com.project2.imfd.repo.ItemRepository;

@Service
public class ItemService {

	private final ItemRepository ir;
	
	public ItemService(ItemRepository ir) {
		this.ir = ir;
	}
	
	public Item addItem(Item item) {
		return ir.save(item);
	}
	
	
	
	public void deleteItem(Integer itemno) {
		ir.deleteById(itemno);
	}
	
	
	public Item getItembyId(Integer itemno){
		return ir.findItemByitemno(itemno).orElseThrow(() -> new ProductNotFound("This product is not available!"));
	}
	
	
	public List<Item> getAllItems(){
		return ir.findAll();
		
	}
	
	public Item updateItem(Item item) {
		return ir.save(item);
	}
	
	public void lowerStock(Integer itemno, int q) {
		
		Item item = ir.findById(itemno).orElseThrow(() -> new ProductNotFound("This product is not available"));
		int currentStock = item.getStock();
		currentStock -= q;
		item.setStock(currentStock);
		
	}
	public void raiseStock(Integer itemno, int q) {
		
		Item item = ir.findById(itemno).orElseThrow(() -> new ProductNotFound("This product is not available"));
		int currentStock = item.getStock();
		currentStock += q;
		item.setStock(currentStock);
		
	}
	
	
}

package com.project2.imfd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.imfd.model.Item;
import com.project2.imfd.services.ItemService;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@Getter
@Setter
@ToString
@RequestMapping("/items")
public class ItemController {
	
	private final ItemService srv;
	
	
	public ItemController(ItemService srv) {
		super();
		this.srv = srv;
	}

	@GetMapping("/{itemno}")
	public ResponseEntity<Item> getItemById(@PathVariable Integer itemno){
		Item item = srv.getItembyId(itemno);
		return new ResponseEntity<>(item,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Item>> getAllItems(){
		List<Item> items = srv.getAllItems();
		return new ResponseEntity<>(items,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Item> addItem(@RequestBody Item item){
		Item newItem = srv.addItem(item);
		return new ResponseEntity<>(newItem,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Item> updateItem(@RequestBody Item item){
		Item updateItem = srv.updateItem(item);
		return new ResponseEntity<>(updateItem,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{itemno}")
	public ResponseEntity<?> deleteItem(@PathVariable Integer itemno){
		srv.deleteItem(itemno);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

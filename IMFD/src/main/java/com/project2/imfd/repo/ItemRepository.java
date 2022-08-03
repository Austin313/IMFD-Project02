package com.project2.imfd.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.imfd.model.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item,Integer>{

	void deleteItemByitemno(Integer itemno);

	Optional<Item> findItemByitemno(Integer itemno);
	

}

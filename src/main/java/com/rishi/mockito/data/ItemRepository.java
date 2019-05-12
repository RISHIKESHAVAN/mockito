package com.rishi.mockito.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishi.mockito.model.Item;

//ItemRepository is the data layer.
public interface ItemRepository extends JpaRepository<Item, Integer> {
	// <Item, Integer> - the entity we want to manage is Item and the primary
	// key of the entity is of type Integer.
}

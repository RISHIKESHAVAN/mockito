package com.rishi.mockito.business;

import org.springframework.stereotype.Component;

import com.rishi.mockito.model.Item;

@Component
public class ItemBusinessService {

	public Item retrieveHardcodedItem() {
		return new Item(1, "Ball", 10, 100);
	}

}

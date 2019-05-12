package com.rishi.mockito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishi.mockito.business.ItemBusinessService;
import com.rishi.mockito.model.Item;

@RestController
public class ItemController {

	@Autowired
	private ItemBusinessService businessService;

	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "Ball", 10, 100);
	}

	@GetMapping("/item-from-business-service")
	public Item itesmFromBusinessService() {
		return businessService.retrieveHardcodedItem();
	}

}

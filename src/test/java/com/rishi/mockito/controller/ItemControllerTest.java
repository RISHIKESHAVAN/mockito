package com.rishi.mockito.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.rishi.mockito.business.ItemBusinessService;
import com.rishi.mockito.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean //not @Mock. check out the differences
	private ItemBusinessService itemBusinessService;

	@SuppressWarnings("unused")
	@Test
	public void dummyItem_basic() throws Exception {
		// call "/dummy-item"
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
				/*
				 * .andExpect(content().string(
				 * "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}")
				 * ).andReturn(); since the response here is small and simple,
				 * we are able to use it directly which will not be the case
				 * always. that is when we have to use Json.
				 */
				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}")).andReturn();
		/*
		 * when using content().json the expected value does not have to be an
		 * exact match you can remove quantity, and the test would still pass it
		 * would only check for the values present.
		 */

		/*
		 * Under this .json the code that is actually executed is
		 * JSONAssert.assertEquals(expected, actual, false) the parameters are
		 * replaced as JSONAssert.assertEquals(
		 * "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}",
		 * result.getResponse().getContentAsString(), false)
		 */
	}

	@SuppressWarnings("unused")
	@Test
	public void itemFromBusinessService() throws Exception {
		// call "/item-from-business-service"
		Mockito.when(itemBusinessService.retrieveHardcodedItem()).thenReturn(new Item(2, "Item2", 10, 100));
		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{id:2,name:Item2,price:10,quantity:100}")).andReturn();
	}

}

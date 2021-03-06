package com.rishi.mockito.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@SuppressWarnings("unused")
	@Test
	public void helloWorld_basic() throws Exception {
		// call "/hello-world"
		RequestBuilder request = MockMvcRequestBuilders.get("/hello-world")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()) // is(200)
																				// can
																				// also
																				// be
																				// used
				.andExpect(content().string("Hello World!")).andReturn();
		// verify that response contains "Hello World!"
		// assertEquals("Hello World!",
		// result.getResponse().getContentAsString()); -- as the check is
		// already done in mvcresult.
		// content.string() has to contain the exact expected value.
	}

}

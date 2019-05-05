package com.rishi.mockito.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class ListMockTest {

	List mock = Mockito.mock(List.class);

	@Test
	public void size_basic() {
		Mockito.when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}

	@Test
	public void returnDifferentValues() {
		Mockito.when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}

	@Test
	public void returnWithParameters() {
		Mockito.when(mock.get(0)).thenReturn("hi");
		assertEquals("hi", mock.get(0));
		//assertEquals("hi", mock.get(1));
	}
}

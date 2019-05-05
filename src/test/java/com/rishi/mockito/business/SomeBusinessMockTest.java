package com.rishi.mockito.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.rishi.mockito.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {
	@InjectMocks
	SomeBusinessImpl business = new SomeBusinessImpl();

	@Mock
	SomeDataService someDataServiceMock;

	public void calculateSum_basic() {
		Mockito.when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, business.calculateSumUsingDataService());
	}

	@Test
	public void calculateSum_empty() {
		Mockito.when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumUsingDataService());
	}

	@Test
	public void calculateSum_oneValue() {
		Mockito.when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] { 5 });
		assertEquals(5, business.calculateSumUsingDataService());
	}
};
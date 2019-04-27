package com.rishi.mockito.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rishi.mockito.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {1,2,3};
	}
	
}
 public class SomeBusinessStubTest {

	@Test
	public void calculateSum_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub()); //someDataService would usually be talking to a database.
													            //we don't want our unit test to talk with a db. so we create a stub for someDataService.
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult =6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {});
		int expectedResult =0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {5});
		int expectedResult =5;
		assertEquals(expectedResult, actualResult);
	}
}

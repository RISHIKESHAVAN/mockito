package com.rishi.mockito.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rishi.mockito.data.SomeDataService;

/*But stubs are a headache to maintain.
Interfaces usually have a lot of methods
and we cant be creating a new stub for each method.
Also, in case a new method is added to the interface,
then all the stubs have to be updated.*/

class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {1,2,3};
	}
}

class SomeDataServiceStubEmptyStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
	
}

class SomeDataServiceStubOneElement implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {5};
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

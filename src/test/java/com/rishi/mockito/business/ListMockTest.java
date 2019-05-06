package com.rishi.mockito.business;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
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
		//assertEquals("hi", mock.get(1)); -- will fail as only get(0) has been mocked.
	}
	
	@Test
	public void returnWithGenericParameters() {
		Mockito.when(mock.get(Mockito.anyInt())).thenReturn("hi"); //anyInt() is the argument matcher.
		assertEquals("hi", mock.get(0));
		assertEquals("hi", mock.get(1));
		assertEquals("hi", mock.get(2));
	}
	
	@SuppressWarnings("unused")
	@Test
	public void verificationBasics() { //to verify the number of calls done on a method
		String value = (String) mock.get(0);
		
		Mockito.verify(mock).get(0); //verify() - Verifies certain behavior happened once.
		Mockito.verify(mock).get(Mockito.anyInt());
		Mockito.verify(mock, Mockito.times(1)).get(Mockito.anyInt());
		
		String value1 = (String) mock.get(1);
		//Mockito.verify(mock).get(Mockito.anyInt()); - this would fail as verify checks for the call done once.
		Mockito.verify(mock, Mockito.atMost(2)).get(Mockito.anyInt());
		Mockito.verify(mock, Mockito.never()).get(2);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void argumentCapturing() {
		mock.add("someString");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		Mockito.verify(mock).add(captor.capture()); //we are verifying that an add method is called on mock AND try to capture the argument that is passed.
		assertEquals("someString", captor.getValue());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void multipleArgumentCapturing() {
		mock.add("someString1");
		mock.add("someString2");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		Mockito.verify(mock, Mockito.times(2)).add(captor.capture());
		List<String> allValues = captor.getAllValues();
		
		assertEquals("someString1",allValues.get(0));
		assertEquals("someString2",allValues.get(1));
	}

	@Test
	public void mocking() {
		ArrayList  arrayListMock = Mockito.mock(ArrayList.class);
		System.out.println(arrayListMock.get(0)); //null
		System.out.println(arrayListMock.size()); //.0
		arrayListMock.add("Test1");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size()); //0 - since its a mock, adding new values doesnt affect its size.
		Mockito.when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size()); //5 - since the call has been mocked.
	}
	
	@Test
	public void spying() {
		ArrayList arrayListSpy = Mockito.spy(ArrayList.class); // spys act as the original class. and only required method can be stubbed.
		//System.out.println(arrayListSpy.get(0)); //would throw an exception as there is nothing in it
		arrayListSpy.add("Test1");
		System.out.println(arrayListSpy.get(0)); //Test1
		System.out.println(arrayListSpy.size()); //1
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size()); //2
		Mockito.when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size()); //5 - since the call has been mocked it will always return only 5.
		
		Mockito.verify(arrayListSpy).add("Test2");
	}
}

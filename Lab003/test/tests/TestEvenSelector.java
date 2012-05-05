package tests;

import gr9372.leonov.lab003.implementation.EvenSelector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;


import org.junit.Assert;
import org.junit.Test;


public class TestEvenSelector {
	
	@Test
	public void checkHasNextOneElementList() {
		EvenSelector evenSelector = new EvenSelector();
		List<Integer> data = Arrays.asList(1);
		evenSelector.setIterator(data.iterator());
		Assert.assertTrue(evenSelector.hasNext());
	}
	
	@Test
	public void checkHasNextEmptyList() {
		EvenSelector evenSelector = new EvenSelector();
		List<Integer> data = Arrays.asList();
		evenSelector.setIterator(data.iterator());
		Assert.assertFalse(evenSelector.hasNext());
	}
	
	@Test
	public void checkNextOneEvenElementList() {
		EvenSelector evenSelector = new EvenSelector();
		List<Integer> data = Arrays.asList(6);
		evenSelector.setIterator(data.iterator());
		Assert.assertTrue(evenSelector.next() == 6);
	}
	
	@Test
	public void checkNextOneOddElementList() {
		EvenSelector evenSelector = new EvenSelector();
		List<Integer> data = Arrays.asList(3);
		evenSelector.setIterator(data.iterator());
		Assert.assertNull(evenSelector.next());
	}
	
	@Test (expected=NoSuchElementException.class)
	public void checkNextEmptyList() {
		EvenSelector evenSelector = new EvenSelector();
		List<Integer> data = Arrays.asList();
		evenSelector.setIterator(data.iterator());
		evenSelector.next();
	}
	
	@Test
	public void checkTwoElementList() {
		EvenSelector evenSelector = new EvenSelector();
		List<Integer> data = Arrays.asList(1, 2);
		evenSelector.setIterator(data.iterator());
		List<Integer> result = new ArrayList<>();
		Integer temp = new Integer(0);
		while (evenSelector.hasNext()) {
			temp = evenSelector.next();
			if (temp != null) {
				result.add(temp);
			}
		}
		Assert.assertEquals(result, Arrays.asList(2));
	}
	
}

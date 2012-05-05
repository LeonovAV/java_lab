package tests;

import gr9372.leonov.lab003.implementation.OddSelector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;


public class TestOddSelector {
	
	@Test
	public void checkHasNextOneElementList() {
		OddSelector oddSelector = new OddSelector();
		List<Integer> data = Arrays.asList(1);
		oddSelector.setIterator(data.iterator());
		Assert.assertTrue(oddSelector.hasNext());
	}
	
	@Test
	public void checkHasNextEmptyList() {
		OddSelector oddSelector = new OddSelector();
		List<Integer> data = Arrays.asList();
		oddSelector.setIterator(data.iterator());
		Assert.assertFalse(oddSelector.hasNext());
	}
	
	@Test
	public void checkNextOneOddElementList() {
		OddSelector oddSelector = new OddSelector();
		List<Integer> data = Arrays.asList(3);
		oddSelector.setIterator(data.iterator());
		Assert.assertTrue(oddSelector.next() == 3);
	}
	
	@Test
	public void checkNextOneEvenElement() {
		OddSelector oddSelector = new OddSelector();
		List<Integer> data = Arrays.asList(2);
		oddSelector.setIterator(data.iterator());
		Assert.assertNull(oddSelector.next());
	}
	
	@Test (expected = NoSuchElementException.class)
	public void checkNextEmptyList() {
		OddSelector oddSelector = new OddSelector();
		List<Integer> data = Arrays.asList();
		oddSelector.setIterator(data.iterator());
		oddSelector.next();
	}
	
	@Test
	public void checkTwoElementList() {
		OddSelector oddSelector = new OddSelector();
		List<Integer> data = Arrays.asList(7, 2);
		oddSelector.setIterator(data.iterator());
		List<Integer> result = new ArrayList<>();
		Integer temp = new Integer(0);
		while (oddSelector.hasNext()) {
			temp = oddSelector.next();
			if (temp != null) {
				result.add(temp);
			}
		}
		Assert.assertEquals(result, Arrays.asList(7));
	}
	
}

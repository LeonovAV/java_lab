package tests;
import gr9372.leonov.lab003.implementation.SqueredProcessor;

import org.junit.Assert;
import org.junit.Test;



public class TestSqueredProcessor {
	
	@Test
	public void checkZeroSqueredProcessor() {
		SqueredProcessor squeredProcessor = new SqueredProcessor();
		Assert.assertEquals(squeredProcessor.process(0), 0);
	}
	@Test
	public void checkPositiveSqueredProcessor() {
		SqueredProcessor squeredProcessor = new SqueredProcessor();
		Assert.assertTrue(squeredProcessor.process(2) == 4);
	}
	@Test
	public void checkNegativeSqueredProcessor() {
		SqueredProcessor squeredProcessor = new SqueredProcessor();
		Assert.assertTrue(squeredProcessor.process(-7) == 49);
	}
	
}

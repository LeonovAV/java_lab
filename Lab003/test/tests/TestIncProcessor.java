package tests;
import gr9372.leonov.lab003.implementation.IncProcessor;

import org.junit.Assert;
import org.junit.Test;


public class TestIncProcessor {
	
	@Test
	public void checkZeroIncProcessor() {
		IncProcessor incProcessor = new IncProcessor();
		Assert.assertTrue(incProcessor.process(0) == 1);
	}
	@Test
	public void checkNegativeIncProcessor() {
		IncProcessor incProcessor = new IncProcessor();
		Assert.assertTrue(incProcessor.process(-5) == -4);
	}
	@Test
	public void checkPositiveIncProcessor() {
		IncProcessor incProcessor = new IncProcessor();
		Assert.assertTrue(incProcessor.process(9) == 10);
	}
	
}

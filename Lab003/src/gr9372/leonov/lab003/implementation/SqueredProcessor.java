package gr9372.leonov.lab003.implementation;

import gr9372.leonov.lab003.lib.Processor;

public class SqueredProcessor implements Processor {

	@Override
	public int process(int number) {
		return number * number;
	}

}

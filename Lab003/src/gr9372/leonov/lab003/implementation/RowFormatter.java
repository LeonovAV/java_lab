package gr9372.leonov.lab003.implementation;

import gr9372.leonov.lab003.lib.Formatter;

import java.util.Collection;


public class RowFormatter implements Formatter {

	@Override
	public void out(Collection<Integer> data) {
		for (Integer i : data) {
			System.out.print(i + " ");
		}
	}

}

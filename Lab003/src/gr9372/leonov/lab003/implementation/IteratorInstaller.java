package gr9372.leonov.lab003.implementation;

import gr9372.leonov.lab003.lib.Selector;

import java.util.Iterator;

public abstract class IteratorInstaller implements Selector {
	
	Iterator<Integer> iterator;

	public void setIterator(Iterator<Integer> iterator) {
		this.iterator = iterator;
	}

}

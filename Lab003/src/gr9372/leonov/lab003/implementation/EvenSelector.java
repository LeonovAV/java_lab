package gr9372.leonov.lab003.implementation;

public class EvenSelector extends IteratorInstaller {

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public Integer next() {
		int temp = iterator.next();
		if (temp % 2 == 0) {
			return temp;
		}
		return null;
	}

	@Override
	public void remove() {
	}

}

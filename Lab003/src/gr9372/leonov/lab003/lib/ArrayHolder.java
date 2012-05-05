package gr9372.leonov.lab003.lib;


import java.util.ArrayList;
import java.util.List;


public class ArrayHolder {
	
	final private List<Integer> data = new ArrayList<Integer>();
	private Processor processor;
	private Selector selector;
	private Formatter formatter;
	
	public void setProcessor(Processor processor) {
		this.processor = processor;
	}
	public void setSelector(Selector selector) {
		this.selector = selector;
	}
	public void setFormatter(Formatter formatter) {
		this.formatter = formatter;
	}
	public void process() {
		List<Integer> result = new ArrayList<>();
		selector.setIterator(data.iterator());
		Integer temp = new Integer(0);
		while (selector.hasNext()) {
			temp = selector.next();
			if (temp != null) {
				result.add(processor.process(temp));
			}
		}
		formatter.out(result);
	}
	public List<Integer> getData() {
		return data;
	}
	public ArrayHolder(List<Integer> data) {
		this.data.addAll(data);
	}
	
}

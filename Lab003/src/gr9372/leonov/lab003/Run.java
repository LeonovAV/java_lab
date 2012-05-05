package gr9372.leonov.lab003;

import gr9372.leonov.lab003.implementation.ColumnFormatter;
import gr9372.leonov.lab003.implementation.EvenSelector;
import gr9372.leonov.lab003.implementation.IncProcessor;
import gr9372.leonov.lab003.implementation.OddSelector;
import gr9372.leonov.lab003.implementation.RowFormatter;
import gr9372.leonov.lab003.implementation.SqueredProcessor;
import gr9372.leonov.lab003.lib.ArrayHolder;
import gr9372.leonov.lab003.lib.Formatter;
import gr9372.leonov.lab003.lib.Processor;
import gr9372.leonov.lab003.lib.Selector;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		ArrayHolder arrayHolder = new ArrayHolder(data);
		
		data.set(0, 100);
		if (data.equals(arrayHolder.getData())) {
			System.out.println("Error");
		}
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("What element do you want to process? (Odd/Even)");
		String answer = scanner.nextLine();
		Selector selector = new EvenSelector();
		if (answer.equals("Odd")) {
			selector = new OddSelector();
		}
		arrayHolder.setSelector(selector);
		
		System.out.println("What action to perform? (Inc/Sqr)");
		answer = scanner.nextLine();
		Processor processor = new SqueredProcessor();
		if (answer.equals("Inc")) {
			processor = new IncProcessor();
		}
		arrayHolder.setProcessor(processor);
		
		System.out.println("What kind of output? (Row/Col)");
		answer = scanner.nextLine();
		Formatter formatter = new RowFormatter();
		if (answer.equals("Col")) {
			formatter = new ColumnFormatter();
		}
		arrayHolder.setFormatter(formatter);
		
		arrayHolder.process();
	}

}

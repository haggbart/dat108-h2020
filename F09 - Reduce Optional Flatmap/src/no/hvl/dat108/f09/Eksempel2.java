package no.hvl.dat108.f09;

import java.util.Arrays;
import java.util.List;

public class Eksempel2 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);
		
		//Alle forbokstavene i fornavnet i en streng - reduce
		String forbokstaver = null;
		System.out.println(forbokstaver);
		
		//Antall personer - count
		long antall = 0;
		System.out.println(antall);
		
		//Om vi har data som matcher - anyMatch, allMatch, noneMatch
		boolean match = false;
		System.out.println(match);

	}

}





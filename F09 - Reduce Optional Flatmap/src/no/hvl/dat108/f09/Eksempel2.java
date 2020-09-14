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
		
		//Alle forbokstavene i fornavnene i en streng - reduce "CLTCM"
		String forbokstaver = people.stream()
				.map(p -> "" + p.getFirstName().charAt(0))
				.reduce("", (res, bokstav) -> res+bokstav);
		
		System.out.println(forbokstaver);
		
		//Antall personer - count
		long antall = people.stream().count();
		System.out.println(antall);
		
		//Om vi har data som matcher - anyMatch, allMatch, noneMatch
		//Er alle over 30 år?
//		boolean match = people.stream().allMatch(p -> p.getAge() > 30);
		//Er noen over 60 år?
		boolean match = people.stream().anyMatch(p -> p.getAge() > 60);
		System.out.println(match);

	}

}





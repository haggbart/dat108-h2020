package no.hvl.dat108;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Eksempel1og2 {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));

		//Skrive ut alle med fornavn som begynner på "C"
		
//		for (Person p : people) {
//			if (p.getFirstName().startsWith("C")) {
//				System.out.println(p);
//			}
//		}
		
		people.stream()
				.filter(p -> p.getFirstName().startsWith("C"))
				.forEach(System.out::println);

		
		//Lage en liste av etternavnene til de som er over 50 år
		
//		List<String> etternavnene = new ArrayList<>();
//		for(Person p : people) {
//			if (p.getAge() > 50) {
//				etternavnene.add(p.getLastName());
//			}
//		}
//		System.out.println(etternavnene);
		
		List<String> lastNames = people.stream() // FROM people
				.filter(p -> p.getAge() > 50)    // WHERE age > 50
				.map(Person::getLastName)       // SELECT lastName
				.collect(Collectors.toList());
		
		System.out.println(lastNames);
		
	}

}

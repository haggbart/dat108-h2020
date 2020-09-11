package no.hvl.dat108;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Eksempel4 {
	
	public static void main(String[] args) {
		
		//Skrive ut alle partall i området [1,10>
		IntStream.range(1, 10)
				.filter(i -> i % 2 == 0)
				.forEach(i -> System.out.print(i + " "));
		
		System.out.println();
		//Skrive ut kvadratet av alle tallene området [1,10>
		IntStream.range(1, 10)
				.map(i -> i*i)
				.forEach(i -> System.out.print(i + " "));
				
		System.out.println();
		//For en strøm av tallene 100, 103, 106, 109, ...
		//   skriv ut de 10 første som er delelig med 4
		Stream.iterate(100, x -> x + 3)
				.filter(i -> i % 4 == 0)
				.limit(10)
				.forEach(i -> System.out.print(i + " "));
		
		System.out.println();
		//For en stream av strenger, skriv dem ut sortert uten duplikater
		Stream.of("Per", "Arne", "Per", "Knut", "Lars")
				.distinct()
				.sorted()
				.forEach(s -> System.out.print(s + " "));
		
	}
}

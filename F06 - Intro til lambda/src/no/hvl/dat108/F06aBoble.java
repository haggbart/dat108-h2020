package no.hvl.dat108;

import java.util.Arrays;
import java.util.List;

public class F06aBoble {
	
	private static <T extends Comparable<T>> void sorter(List<T> listen) {
		for (int i=0; i<listen.size(); i++) {
			for (int j=1; j<listen.size(); j++) {
				if (listen.get(j-1).compareTo(listen.get(j)) > 0) { //Kunne bytte denne!?
					T temp = listen.get(j-1);
					listen.set(j-1, listen.get(j));
					listen.set(j, temp);
				}
			}
		}
	}

	private static <T extends Comparable<T>> void sorter(List<T> listen, Sammenligner<T> s) {
		for (int i=0; i<listen.size(); i++) {
			for (int j=1; j<listen.size(); j++) {
				if (s.sammenlign(listen.get(j-1), listen.get(j)) > 0) { //Kunne bytte denne!?
					T temp = listen.get(j-1);
					listen.set(j-1, listen.get(j));
					listen.set(j, temp);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		List<Integer> listeAvTall = Arrays.asList(4,2,7,5,9,1);
		sorter(listeAvTall);
		System.out.println(listeAvTall);

		List<String> listeAvString = Arrays.asList("Aaa", "Xxx", "Bbb", "Kkk");
		sorter(listeAvString);
		System.out.println(listeAvString);
		
		List<Person> listeAvPersoner = Arrays.asList(
				new Person("Anne", "Persen"), new Person("Per", "Andersen"),
				new Person("Knut", "Svendsen"));
		sorter(listeAvPersoner);
		System.out.println(listeAvPersoner);
		
		//Jeg ønsker å sortere personene på fornavn! Hva gjør vi???
		Sammenligner<Person> s = new FornavnSammenligner();
		sorter(listeAvPersoner, s);
		System.out.println(listeAvPersoner);
		
		//Sortere på fødselsår
//		sorter(listeAvPersoner, new Sammenligner<Person>() {
//			@Override
//			public int sammenlign(Person a, Person b) {
//				// kode for å sammenligne alder ...
//			}
//		});
//		System.out.println(listeAvPersoner);
	}
}




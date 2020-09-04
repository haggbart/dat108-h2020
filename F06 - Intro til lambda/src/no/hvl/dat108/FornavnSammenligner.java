package no.hvl.dat108;

public class FornavnSammenligner implements Sammenligner<Person> {

	@Override
	public int sammenlign(Person a, Person b) {
		return a.fornavn.compareTo(b.fornavn);
	}

}

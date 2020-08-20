package no.hvl.dat108.f01;

public class RaceCondition {

	public static void main(String[] args) throws InterruptedException {
		
		Teller teller = new Teller();
		
		Thread telleOppTraad = new TelleOppTraad(teller, 100000);
		Thread telleNedTraad = new TelleNedTraad(teller, 100000);
		
		telleOppTraad.start();
		telleNedTraad.start();
		
		telleOppTraad.join();
		telleNedTraad.join();
		
		System.out.println(teller.getVerdi());
		
	}

}

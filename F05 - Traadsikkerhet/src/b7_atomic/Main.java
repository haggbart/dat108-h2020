package b7_atomic;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		TellerAtomic teller = new TellerAtomic();
		
		Thread telleOppTraad = new TelleOppTraad(teller, 100000);
		Thread telleNedTraad = new TelleNedTraad(teller, 100000);
		
		telleOppTraad.start();
		telleNedTraad.start();
		
		telleOppTraad.join();
		telleNedTraad.join();
		
		System.out.println(teller.getVerdi());
		
	}

}

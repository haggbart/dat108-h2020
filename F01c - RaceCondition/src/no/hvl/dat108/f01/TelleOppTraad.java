package no.hvl.dat108.f01;

public class TelleOppTraad extends Thread {

	private Teller teller;
	private int antallGanger;

	public TelleOppTraad(Teller teller, int antallGanger) {
		this.teller = teller;
		this.antallGanger = antallGanger;
	}

	@Override
	public void run() {
		for (int i = 0; i < antallGanger; i++) {

				// Kristisk seksjon
				teller.tellOpp(); 
		}
	}

}

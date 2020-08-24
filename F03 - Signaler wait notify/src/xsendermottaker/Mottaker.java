package xsendermottaker;


public class Mottaker extends Thread {

	private Melding melding;
	
	public Mottaker(Melding melding) {
		this.melding = melding;
	}

	@Override
	public void run() {
		
		while (true) {
			
			synchronized(melding) {
				while(melding.erMottatt()) {
					try {
						melding.wait();
					} catch (InterruptedException e) {
					}
				}
				String mottattMelding = melding.motta();
				melding.notifyAll();
				System.out.println("Mottaker har mottatt melding: " + mottattMelding);
			}
			try {
				System.out.println("... prosesserer ...");
				sleep(10_000);
				System.out.println("... Klar!");
			} catch (InterruptedException e) {
			}
		}
	}

}

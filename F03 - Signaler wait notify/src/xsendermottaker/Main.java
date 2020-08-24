package xsendermottaker;

public class Main {
	
	public static void main(String... blablabla) {
		
		Melding m = new Melding();
		
		Sender sender = new Sender(m);
		Mottaker mottaker = new Mottaker(m);
		
		sender.start();
		mottaker.start();
	}


}

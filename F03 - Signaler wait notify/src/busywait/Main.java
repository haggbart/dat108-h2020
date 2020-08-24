package busywait;

public class Main {

	private static String melding;
	
	public static void main(String[] args) {
	
		Thread printlnTraad = new Thread(new Runnable() {
			@Override
			public void run() {
				while (melding == null) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
				System.out.println(melding);
			}
		});
		
		Thread giVerdiTraad = new Thread(new Runnable() {
			@Override
			public void run() {
				melding = "Dette er en melding!";
			}
		});
		
		printlnTraad.start();
		giVerdiTraad.start();
	}

}

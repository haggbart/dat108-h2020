package no.hvl.dat108.f00;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread(
				() -> System.out.println("Utskrift fra anonym Runnable"));
		t.start();
		
		Thread.sleep(10);
		
		System.out.println("Utskrift fra main()");

	}

}

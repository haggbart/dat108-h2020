package no.hvl.dat108.f01;

public class PauseOgStopp {

	public static void main(String[] args) throws InterruptedException {
		
		MinTraad t = new MinTraad("Dingdong-tråd");
		t.start();
		
		Thread.sleep(5000);
		
		t.stopp();
	}

}

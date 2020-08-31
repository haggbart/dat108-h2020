package lockcondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Melding {

	private String innhold;
	
	private Lock laasen = new ReentrantLock();
	private Condition innholdSatt = laasen.newCondition();

	public String getInnhold() {
		
		laasen.lock();
		try {
			while (!harInnhold()) {
				innholdSatt.await();
			}
		} catch (InterruptedException e) {
		} finally {
			laasen.unlock();
		}
		return innhold;
	}

	public void setInnhold(String innhold) {
		
		laasen.lock();
		try {
			this.innhold = innhold;
			innholdSatt.signalAll();
		} finally {
			laasen.unlock();
		}
	}

	public boolean harInnhold() {
		return innhold != null;
	}

}

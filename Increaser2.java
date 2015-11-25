/**
* Week 9, day 18
* 2. Counting
* Sarah Connor
*/

/*
* count is consistent but run is out of order
*/
public class Increaser2 implements Runnable {
	private Counter2 c;
	
	public Increaser2(Counter2 counter) {
		this.c = counter;
	}
	
	public static void main(String args[]) {
		Counter2 counter = new Counter2();
		for (int i = 0; i < 100; i++) {
			Increaser2 increaserTask = new Increaser2(counter);
			Thread t = new Thread(increaserTask);
			t.start();
		}
	}
	
	public void run() {
		System.out.println("Starting at " + c.getCount());
		for (int i = 0; i < 1000; i++) {
			c.increase();
		}
		System.out.println("Stopping at " + c.getCount());
	}
}
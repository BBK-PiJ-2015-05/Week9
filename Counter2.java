/**
* Week 9, day 18
* 2. Counting
* Sarah Connor
*/

public class Counter2 {
	private int n = 0;
		
	public void increase() {
		synchronized(this){
			n++;
		}
		
	}

	public int getCount() {
		return n;
	}
}
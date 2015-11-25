/**
* Week 9, day 18
* 3. Bank Account
* Sarah Connor
*/

public class BankAccount {
	private int balance = 0;
	
	public int getBalance() {
		return balance;
	}
	
	public synchronized void deposit(int money) {
		balance = balance + money;
	}
	
	public int retrieve(int money) {
		int result = 0;
		
		if (balance > money) {
			result = money;
		} else {
			result = balance;
		}
		synchronized(this){
			balance = balance - result;
		}
		return result;
	}
}
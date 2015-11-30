import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;

/**
* Week 9, day 18
* 4. Responsive UI
* Sarah Connor
*/

public class DiningPhilosophers{
	
	static class Philosopher {
		private final String name;
		private final Lock fork = new ReentrantLock();
		private Boolean hasEaten;
		
		public Philosopher(String name){
			this.name = name;
			hasEaten = false;
		}
		
		 public String getName() {
            return this.name;
        }
		
		private boolean grabForks(Philosopher hungryLocke){
			Boolean myFork = false;
			Boolean yourFork = false;
			try{
				myFork = fork.tryLock();
				yourFork = hungryLocke.fork.tryLock();
			}finally{
				if(!(myFork && yourFork)){
					if(myFork){
						fork.unlock();
					}
					if(yourFork){
						hungryLocke.fork.unlock();
					}
				}
			}
			return myFork && yourFork;
		}
		
		public void eat(Philosopher hungryLocke){
			if(grabForks(hungryLocke)){
				try{
					hasEaten = true;
					System.out.format("%s: %s has taken my fork and eaten.\n", this.getName(), hungryLocke.getName());
				}finally{
					fork.unlock();
					hungryLocke.fork.unlock();
				}
			}
		}
	}
	
	static class eatLoop implements Runnable{
		private Philosopher descartes;
		private Philosopher neighbour;
		
		public eatLoop(Philosopher descartes, Philosopher neighbour){
			this.descartes = descartes;
			this.neighbour = neighbour;
		}
		
		public void run(){
			while(!descartes.hasEaten){
				descartes.eat(neighbour);
			}
		}
	}
	
	public static void main (String[] args){
		int numPhils = 0;
		ArrayList<Philosopher> phils = new ArrayList<Philosopher>();
		String philName = "";
		do{
			System.out.println("Which philosophers have come to dinner? (Q to exit)");
			philName = System.console().readLine();
			Philosopher phil = new Philosopher(philName);
			phils.add(phil);
			numPhils++;
		}while(!philName.equals("Q"));
		numPhils -= 1;
		phils.remove(numPhils);
        for(int i = 0; i < numPhils; i++){
			new Thread(new eatLoop(phils.get(i), phils.get((i + 1) % numPhils))).start();
		}
        
	}

}
/**
* Week 9, day 18
* 4. Responsive UI
* Sarah Connor
*/

public class ResponsiveUI implements Runnable{
	
	private final int length;
	private final int taskId;
	private static String buffer;
	private static final int LIMIT = 10;
	
	public ResponsiveUI(int length, int taskId){
		this.length = length;
		this.taskId = taskId;
		this.buffer = "";
	}
	

	public static void main(String[] args){
		for(int i = 0; i < LIMIT; i++){
			System.out.format("Enter the duration (in ms) of task %d: \n", i);
			int inputLength = -1;
			while(inputLength < 0){
				try{
					inputLength = Integer.parseInt(System.console().readLine());
				}catch(NumberFormatException e){
					System.out.println("Invalid number.");
				}
			}
			ResponsiveUI task = new ResponsiveUI(inputLength, i);
			Thread t = new Thread(task);
			t.start();
			if(!buffer.equals("")){
				System.out.println("Finished tasks: " + buffer);
				buffer = "";
			}
		}
		
	}

	@Override
	public void run(){
		try{
			Thread.sleep(length);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		synchronized (buffer){
			if(!buffer.equals("")){
				buffer += ", " + taskId;
			}else{
				buffer = "" + taskId;
			}
		}
	}

}
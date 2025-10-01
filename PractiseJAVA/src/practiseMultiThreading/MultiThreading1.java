package practiseMultiThreading;

public class MultiThreading1 implements Runnable {
	private int threadNumber;
	
	public MultiThreading1(int threadNumber) {
		this.threadNumber = threadNumber;
	}
	@Override
	public void run() {
		System.out.println("Hello from Thread: "+threadNumber);
	}
	
	public static void main(String args[]) {
		for(int i= 1;i <=3;i++) {
			MultiThreading1 myThread = new MultiThreading1(i);
			Thread  t = new Thread(myThread);
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

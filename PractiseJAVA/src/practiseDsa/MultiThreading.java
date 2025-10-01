package practiseDsa;

public class MultiThreading extends Thread {
//	private int threadNumber;
////	
////	public MultiThreading(int threadNumber) {
////		this.threadNumber = threadNumber;
////	}
//	
//	@Override
//	public void run() {
//		for(int i=1;i<=5;i++) {
//			System.out.println(i);// + " from thread: "+threadNumber);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException ex) {
//				
//			}
//		}
//		
//	}
//	
//	public static void main(String args[]) throws InterruptedException {
////		for(int i=1;i<=3;i++) {
////		MultiThreading myThread = new MultiThreading(i);
////		myThread.start();
//////		myThread.join();
////		System.out.println(myThread.isAlive()); 
////		}
////		myThread.run();  will call the run method directly just like a normal class object and doesnt create any new thread
////		myThread.start();  will communicate with jvm to create a new thread for every call and call run() method inside it
//		MultiThreading myThread = new MultiThreading();
//		
//		System.out.println("Before Start: "+myThread.isAlive());
//		
//		myThread.start();
//		
//		System.out.println("After start: "+myThread.isAlive());
//		
////		myThread.join();
//		
//		System.out.println("After join: "+myThread.isAlive());
//	}
	private int threadNumber;
	public MultiThreading(int threadNumber) {
		this.threadNumber = threadNumber;
	}
	@Override
	public void run() {
		System.out.println("Hello from thread "+threadNumber);
		try { 
			Thread.sleep(500);
		} catch(InterruptedException ex) {
			
		}
	}
	
	public static void main(String args[]) {
		MultiThreading thread1 = new MultiThreading(1);
		System.out.println(thread1.isAlive());
		thread1.start();
		System.out.println(thread1.isAlive());
		try {
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(thread1.isAlive());
		
		MultiThreading thread2 = new MultiThreading(2);
		System.out.println(thread2.isAlive());
		thread2.start();
		System.out.println(thread2.isAlive());
		try {
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(thread2.isAlive());
		
		MultiThreading thread3 = new MultiThreading(3);
		
		System.out.println(thread3.isAlive());
		thread3.start();
		System.out.println(thread3.isAlive());
		try {
			thread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(thread3.isAlive());
		
	}

}

public class Verbraucher extends Thread {
	public void run() {
		while (true) {
			System.out.println("Verbraucher.");
			try { Thread.sleep(1000);} catch(InterruptedException e) {};
		}
	}
}

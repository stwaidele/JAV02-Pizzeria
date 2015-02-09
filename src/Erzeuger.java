public class Erzeuger extends Thread {
	public void run() {
		while (true) {
			System.out.println("Erzeuger.");
			try { Thread.sleep(1000);} catch(InterruptedException e) {};
		}
	}
}

import java.util.Random;

public class Verbraucher extends Thread {
	
	// Wartezeit zwischen dem Abholen
	private int sek; 
	
	// Pseudo-Zufallszahlengenerator
	private Random zufall = new Random(System.currentTimeMillis());
	
	// Default-Constructor: Keine Parameter, zufällige Wartezeit
	public Verbraucher() {
		sek = 1 + zufall.nextInt(20);
	}
	// Construcor: Vorgegebene Wartezeit in Sekunden
	public Verbraucher(int i) {
		sek = i;
	}
	
	Queue queue = Queue.getInstance();
	
	public void run() {
		while (true) {
			System.out.println("V rein : "+queue.speicher.size());
			try { queue.speicher.take();} catch(InterruptedException e) {};
			System.out.println("V raus : "+queue.speicher.size());
			try { Thread.sleep(sek*pizzeria.SLOW_DOWN);} catch(InterruptedException e) {};
		}
	}
}

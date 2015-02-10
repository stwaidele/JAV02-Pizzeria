import java.util.Random;

public class Erzeuger extends Thread {
	
	// Wartezeit zwischen dem Erzeugen
	private int sek; 
	
	// Pseudo-Zufallszahlengenerator
	private Random zufall = new Random(System.currentTimeMillis());
	
	// Default-Constructor: Keine Parameter, zufällige Wartezeit
	public Erzeuger() {
		sek = 1 + zufall.nextInt(20);
	}
	// Construcor: Vorgegebene Wartezeit in Sekunden
	public Erzeuger(int i) {
		sek = i;
	}

	Queue queue = Queue.getInstance();	
	
	public void run() {
		while (true) {
			pizzeria.securityCam.log("E", queue.speicher.size());
			try{queue.speicher.put(1);} catch(InterruptedException e) {};
			try{Thread.sleep(sek*pizzeria.SLOW_DOWN);} catch(InterruptedException e) {};
		}
	}
}

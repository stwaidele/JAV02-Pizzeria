import java.util.Random;

public abstract class Akteur extends Thread {
	// Wartezeit zwischen dem Abholen
	private int sek; 
	private boolean immerZufall = false;
	private String meinName;
	
	public Queue queue = Queue.getInstance();

	// Pseudo-Zufallszahlengenerator
	private Random zufall = new Random(System.currentTimeMillis());
	
	// Default-Constructor: Keine Parameter, zufällige Wartezeit, 
	// Name "A" für Akteur
	public Akteur() {
		sek = 1 + zufall.nextInt(Pizzeria.MAX_RANDOM_WAIT-1);
		meinName = "A";
	}
	// Constructor: Vorgegebene Wartezeit & Name
	public Akteur(String s, int i) {
		sek = i;
		if(i==0) {
			immerZufall = true;
		}
		meinName = s;
	}
	
	public void run() {
		while (true) {
			// Wartezeit ermitteln... 
			// Falls jedes Mal zufällig gewartet werden soll:
			if (immerZufall) {
				// Zufällige Wartezeit
				sek = 1 + zufall.nextInt(Pizzeria.MAX_RANDOM_WAIT-1);
			}
			// Warten... (bzw. satt sein, oder nächstes Element vorbereiten, ..)
			try { Thread.sleep(sek*Pizzeria.SLOW_DOWN);} 
			catch (InterruptedException e) {};
		
			// Loggen...
			Pizzeria.logger.log(meinName, sek, queue.speicher.size());

			// Handeln!
			aktion();

		}
	}
	
	protected abstract void aktion();
}

import java.util.Random;


public abstract class Akteur extends Thread {
	// Wartezeit zwischen dem Abholen
	private int sek; 
	private boolean immerZufall = false;
	private String meinName;
	
	public Queue queue = Queue.getInstance();

	
	// Pseudo-Zufallszahlengenerator
	private Random zufall = new Random(System.currentTimeMillis());
	
	// Default-Constructor: Keine Parameter, zufällige Wartezeit, Name "A" für Akteur
	public Akteur() {
		this("A");
	}
	// Construcor: Vorgegebene Wartezeit in Sekunden
	// i == 0 : Jedes Mal eine andere zufällige Wartezeit
	public Akteur(int i) {
		sek = i;
		if(i==0) {
			immerZufall = true;
		}
	}
	// Constructor: Vorgegebener Name
	public Akteur(String s) {
		sek = 1 + zufall.nextInt(pizzeria.MAX_RANDOM_WAIT-1);
		meinName = s;
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
			// Falls jedes Mal zufällig gewartet werden soll:
			// Wartezeit bestimmen...
			if (immerZufall) {
				sek = 1 + zufall.nextInt(pizzeria.MAX_RANDOM_WAIT-1);
			}
			// Warten...
			try { Thread.sleep(sek*pizzeria.SLOW_DOWN);} catch(InterruptedException e) {};
			// Loggen...
			pizzeria.securityCam.log(meinName, sek, queue.speicher.size());

			// Handeln!
			aktion();
		}
	}
	
	protected abstract void aktion();

}

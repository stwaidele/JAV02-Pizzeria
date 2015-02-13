public class Verbraucher extends Akteur {
	
	// Default-Constructor: Keine Parameter, zufällige Wartezeit
	public Verbraucher() {
		super("V");
	}
	// Constructor: Vorgegebener Name für Ausgabe
	public Verbraucher(String s) {
		super(s);
	}	
	// Construcor: Vorgegebene Wartezeit in Sekunden
	// i == 0 : Jedes Mal eine andere zufällige Wartezeit
	public Verbraucher(int i) {
		super("V", i);
	}
	// Constructor: Vorgegebene Wartezeit & Name
	public Verbraucher(String s, int i) {
		super(s, i);
	}
		
	public void aktion() {
			try { queue.speicher.take();} catch(InterruptedException e) {};
	}
}

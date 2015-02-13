public class Erzeuger extends Akteur {
	
	// Default-Constructor: Keine Parameter, zufällige Wartezeit
	public Erzeuger() {
		super("E");
	}
	// Constructor: Vorgegebener Name für Ausgabe
	public Erzeuger(String s) {
		super(s);
	}	
	// Construcor: Vorgegebene Wartezeit in Sekunden
	// i == 0 : Jedes Mal eine andere zufällige Wartezeit
	public Erzeuger(int i) {
		super("E", i);
	}
	// Constructor: Vorgegebene Wartezeit & Name
	public Erzeuger(String s, int i) {
		super(s, i);
	}
		
	public void aktion() {
		try{queue.speicher.put(1);} catch(InterruptedException e) {};
	}
}


public class Erzeuger extends Akteur {
	
	// Default-Constructor: Keine Parameter, zufällige Wartezeit
	public Erzeuger() {
		super();
	}
	// Constructor: Vorgegebene Wartezeit & Name
	public Erzeuger(String s, int i) {
		super(s, i);
	}
		
	public void aktion() {
		try{queue.speicher.put(1);} catch(InterruptedException e) {};
	}
}


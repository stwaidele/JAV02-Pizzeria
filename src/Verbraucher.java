public class Verbraucher extends Akteur {
	
	// Default-Constructor: Keine Parameter, zufällige Wartezeit
	public Verbraucher() {
		super();
	}
	// Constructor: Vorgegebene Wartezeit & Name
	public Verbraucher(String s, int i) {
		super(s, i);
	}
		
	public void aktion() {
			try { queue.speicher.take();} catch(InterruptedException e) {};
	}
}

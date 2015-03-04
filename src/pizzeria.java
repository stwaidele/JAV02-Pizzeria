import java.util.Scanner;
import java.util.ArrayList;

public class Pizzeria {

	static final long SLOW_DOWN = 1;
	static final int QUEUE_SIZE = 15;
	static final int MAX_RANDOM_WAIT = 15;
	static final String FILL_LEVEL_FORMAT = "%1$4s";
	static final String WAITED_FOR_FORMAT = "%1$3s";
	
	public static Logger logger = new Logger(); 

	private static Erzeuger e;
	private static ArrayList <Verbraucher> alleVerbraucher 
	= new ArrayList<Verbraucher>();
	
	public static void main(String[] args) {
		int nv;				// Anzahl der Verbraucher
		int t;				// Wartezeit
		String konfig = ""; // Zur Dokumentation

		Scanner s = new Scanner(System.in);
		System.err.print("Wartezeit für Erzeuger? "
				+ "(0 für jedes Mal eine neue zufällige Wartezeit) ");
		t = s.nextInt();
		// Erzeuger erstellen
		e = new Erzeuger("E ", t);
		// Dokumentation
		konfig = "E"+t;
		
		System.err.print("Wie viele Verbraucher? ");
		nv = s.nextInt();
		
		konfig += "V";
		for (int i=1; i<=nv; i++) {
			System.err.print("Wartezeit für Verbraucher " + i + "? "
					+ "(0 für jedes Mal eine neue zufällige Wartezeit) ");
			t = s.nextInt();
			alleVerbraucher.add(new Verbraucher("V"+i, t));
			// Dokumentation
			konfig += t + ".";
		}				
		s.close();
		
		System.err.println("Pizzeria JAV02 hat geöffnet.");
		// Dokumentation
		System.out.println("QUEUE_SIZE = " + QUEUE_SIZE
						   + "; MAX_RANDOM_WAIT = " + MAX_RANDOM_WAIT
						   + "; SLOW_DOWN = " + SLOW_DOWN + ";");
		System.out.println("Konfiguration: " + konfig);
		
		Queue queue = Queue.getInstance();
		queue.setSpeichergroesse(QUEUE_SIZE);

		e.start();
		for(Verbraucher verbraucher: alleVerbraucher) {
			verbraucher.start();
		}		
	}
}

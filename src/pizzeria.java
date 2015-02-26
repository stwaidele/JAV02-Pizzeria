import java.util.Scanner;
import java.util.ArrayList;

public class Pizzeria {

	static final long SLOW_DOWN = 100;
	static final int QUEUE_SIZE = 15;
	static final int MAX_RANDOM_WAIT = 50;
	static final String FILL_LEVEL_FORMAT = "%1$4s";
	static final String WAITED_FOR_FORMAT = "%1$3s";
	
	public static Logger logger = new Logger(); 

	private static Erzeuger e;
	private static ArrayList <Verbraucher> alleVerbraucher 
	= new ArrayList<Verbraucher>();
	
	public static void main(String[] args) {
		int nv;    // Anzahl der Verbraucher

		Scanner s = new Scanner(System.in);
		System.out.print("Wartezeit für Erzeuger? "
				+ "(0 für jedes Mal eine neue zufällige Wartezeit) ");
		e = new Erzeuger("E ", s.nextInt());
		
		System.out.print("Wie viele Verbraucher? ");
		nv = s.nextInt();
		for (int i=1; i<=nv; i++) {
			System.out.print("Wartezeit für Verbraucher " + i + "? "
					+ "(0 für jedes Mal eine neue zufällige Wartezeit) ");
			alleVerbraucher.add(new Verbraucher("V"+i, s.nextInt()));
		}				
		s.close();
		
		System.out.print("Pizzeria JAV02 hat geöffnet.");

		Queue queue = Queue.getInstance();
		queue.setSpeichergroesse(QUEUE_SIZE);

		e.start();
		for(Verbraucher verbraucher: alleVerbraucher) {
			verbraucher.start();
		}		
	}
}

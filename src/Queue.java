import java.util.concurrent.LinkedBlockingQueue;

public class Queue {
	// Klassisches Singleton Entwurfsmuster
	// vgl. GoF, Seite 127ff
	// Java Implementierung z.B. 
	// http://www.javaworld.com/article/2073352/core-java/simply-singleton.html
	private static Queue instance = null;
	public   LinkedBlockingQueue<Integer> speicher 
	= new LinkedBlockingQueue<>();
	
	// Leerer, geschützter Constructor verhindert Instanziierung
	protected Queue() {}

	public static Queue getInstance() {
		if(instance == null) {
			instance = new Queue();
		}
		return instance;
	}	
	// Möglichkeit die Größe der Queue zu bestimmen/verändern
	public void setSpeichergroesse(int i) {
		// Neue Queue mit gewünschter Größe erzeugen & referenzieren
		speicher = new LinkedBlockingQueue<>(i);
		// Die alte Queue wird nicht mehr referenziert 
		// und per Garbage Collection freigegeben,
	}
}

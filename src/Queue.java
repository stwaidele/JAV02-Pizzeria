//
// Queue: Implementierung einer Warteschlange
//        Entuwrfmuster: Singleton
import java.util.concurrent.LinkedBlockingQueue;

public class Queue {
	// Klassisches Singleton Entwurfsmuster
	// vgl. GoF, Seite 127ff
	// Java Implementierung z.B. http://www.javaworld.com/article/2073352/core-java/simply-singleton.html
	private static Queue instance = null;
	public   LinkedBlockingQueue<Integer> speicher = new LinkedBlockingQueue<>();
	
	// Leerer, geschützter Constructor verhindert Instanziierung
	protected Queue() {}

	public static Queue getInstance() {
		if(instance == null) {
			instance = new Queue();
		}
		return instance;
	}	
	public void setSpeichergroesse(int i) {
		speicher = new LinkedBlockingQueue<>(i);
	}
}

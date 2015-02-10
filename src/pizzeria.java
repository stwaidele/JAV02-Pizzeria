public class pizzeria {

	static final long SLOW_DOWN = 25;
	static final int QUEUE_SIZE = 150;
	static final String FILL_LEVEL_FORMAT = "   ";
	
	public static Security securityCam = new Security(); 

	public static void main(String[] args) {
		securityCam.log("Pizzeria JAV02 hat geöffnet.");

		Erzeuger e = new Erzeuger(1);
		Verbraucher v1 = new Verbraucher(5);
		Verbraucher v2 = new Verbraucher(10);
		Verbraucher v3 = new Verbraucher(15);		

		Queue queue = Queue.getInstance();
		queue.setSpeichergroesse(QUEUE_SIZE);

		e.start();
		
		v1.start();
		v2.start();		
		v3.start();
	}
}

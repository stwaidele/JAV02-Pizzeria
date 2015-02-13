public class pizzeria {

	static final long SLOW_DOWN = 1000;
	static final int QUEUE_SIZE = 150;
	static final int MAX_RANDOM_WAIT = 50;
	static final String FILL_LEVEL_FORMAT = "000";
	static final String WAITED_FOR_FORMAT = "000";
	
	public static Security securityCam = new Security(); 

	public static void main(String[] args) {
		securityCam.log("Pizzeria JAV02 hat geöffnet.");
		Erzeuger e = new Erzeuger(1);
		Verbraucher v1 = new Verbraucher(3);
		//Verbraucher v2 = new Verbraucher(0);
		//Verbraucher v3 = new Verbraucher(0);		

		Queue queue = Queue.getInstance();
		queue.setSpeichergroesse(QUEUE_SIZE);

		e.start();
		
		v1.start();
		//v2.start();		
		//v3.start();
	}
}

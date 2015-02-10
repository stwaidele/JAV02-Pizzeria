public class pizzeria {

	static final long SLOW_DOWN = 100;
	
	public static Security securityCam = new Security(); 

	public static void main(String[] args) {
		securityCam.log("Pizzeria JAV02 hat geöffnet.");

		Erzeuger e = new Erzeuger(1);
		Verbraucher v1 = new Verbraucher();
		Verbraucher v2 = new Verbraucher(7);
		Verbraucher v3 = new Verbraucher(17);		

		Queue queue = Queue.getInstance();
		queue.setSpeichergroesse(5);

		e.start();
		
		v1.start();
		v2.start();		
		v3.start();
	}

}

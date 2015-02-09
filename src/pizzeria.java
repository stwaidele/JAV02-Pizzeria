
public class pizzeria {

	public static Security securityCam = new Security(); 

	public static void main(String[] args) {
		securityCam.log("Pizzeria JAV02 hat gešffnet.");

		Erzeuger e = new Erzeuger();
		Verbraucher v1 = new Verbraucher();
		Verbraucher v2 = new Verbraucher();
		Verbraucher v3 = new Verbraucher();

		e.start();
		
		try { Thread.sleep(1000);} catch(InterruptedException f) {};
		v1.start();

		try { Thread.sleep(5000);} catch(InterruptedException f) {};
		v2.start();
		
		try { Thread.sleep(10000);} catch(InterruptedException f) {};
		v3.start();
	}

}

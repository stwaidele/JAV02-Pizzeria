public class Logger {
	public void log(String s, Integer t, Integer n) {
		// Zuerst die Zeile erzeugen...
		s = s + "(" + String.format(Pizzeria.WAITED_FOR_FORMAT, t) + "sek): " 
		      + String.format(Pizzeria.FILL_LEVEL_FORMAT, n) + " |";
		// n Sternchen
		for (int i=0;i<n;i++) {
			s = s + "*";
		}
		// und QUEUE_SIZE-n Leerzeichen
		for (int i=n;i<Pizzeria.QUEUE_SIZE;i++){
			s = s + " ";
		}
		s = s + "|";
		//... und anschließend mit EINEM println() ausgeben
		// (wg. Threadsicherheit)
		System.out.println(s);
	}
}

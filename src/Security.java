import java.text.DecimalFormat;

public class Security {
	public void log(String s) {
		System.out.println(s);
	}
	public void log(String s, Integer n) {
		s = s + ": " + new DecimalFormat(pizzeria.FILL_LEVEL_FORMAT).format(n) + " |";
		for (int i=0;i<n;i++) {
			s = s + "*";
		}
		for (int i=n;i<pizzeria.QUEUE_SIZE;i++){
			s = s + " ";
		}
		s = s + "|";
		System.out.println(s);
	}
	public void log(String s, Integer t, Integer n) {
		
		s = s + "(" + String.format(pizzeria.WAITED_FOR_FORMAT, t) + "sek): " + String.format(pizzeria.FILL_LEVEL_FORMAT, n) + " |";
		// n Sternchen
		for (int i=0;i<n;i++) {
			s = s + "*";
		}
		// und QUEUE_SIZE-n Leerzeichen
		for (int i=n;i<pizzeria.QUEUE_SIZE;i++){
			s = s + " ";
		}
		s = s + "|";
		System.out.println(s);
	}

}

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class mainpureba {

	public static void main(String[] args) {
		 LocalTime hora1 = LocalTime.of(10, 00);
		 LocalTime hora2 = LocalTime.of(11, 25);
	
		 
		 System.out.println(	 hora1.until(hora2, ChronoUnit.MINUTES));
	}

}

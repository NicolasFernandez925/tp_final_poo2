package sem_venta;


public class Numerador {
	private static int numeroDeControl;
	
	public Numerador() {
		Numerador.numeroDeControl = 0;
	}
	
	public static int siguienteNroDeControl() {
		numeroDeControl += 1;
		return numeroDeControl;
	}
	
	public static void resetContador() {
		numeroDeControl = 0;
	}
}

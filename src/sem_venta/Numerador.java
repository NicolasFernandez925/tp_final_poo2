package sem_venta;


public class Numerador {
	private int numeroDeControl;
	
	public Numerador() {
		numeroDeControl = 0;
	}
	
	public int siguienteNroDeControl() {
		numeroDeControl += 1;
		return numeroDeControl;
	}
	
	public void resetNumerador() {
		numeroDeControl = 0;
	}
}

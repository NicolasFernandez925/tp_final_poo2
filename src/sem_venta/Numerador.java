package sem_venta;


public class Numerador implements INumerador{
	private int numeroDeControl;
	
	public Numerador() {
		numeroDeControl = 0;
	}
	
	public int siguienteNumero() {
		numeroDeControl += 1;
		return numeroDeControl;
	}
	
}

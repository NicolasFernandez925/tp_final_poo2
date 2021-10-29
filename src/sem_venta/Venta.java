package sem_venta;

import java.time.LocalTime;

public abstract class Venta {
	private int nroDeControl;
	
	// el localtime.now no tiene fecha + hora?
	private LocalTime hora;
	private LocalTime fecha;
	
	public Venta(LocalTime hora, LocalTime fecha) {
		this.hora = hora;
		this.fecha  = fecha;
	}
	
	public LocalTime getHora() {
		return this.hora;
	}
	
	public int generarNumeroDeControl() {
		this.nroDeControl += 1;
		return this.nroDeControl;
	}
	
	public LocalTime getFecha() {
		return this.fecha;
	}
	
	
	//Estos dos metodos parecen de PuntoDeVenta mas que de la venta misma
	public int totalDeHorasVendidas() {
		//que vendria a ser el total de horas?
		return 1; 
	}
	
	public double totalMontoDeRecargas() {
		return 1;
	}
	
	

}

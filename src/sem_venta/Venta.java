package sem_venta;

import java.time.LocalTime;

import sem_PuntoDeVenta.PuntoDeVenta;

public abstract class Venta {
	private int nroDeControl = 0;
	private PuntoDeVenta puntoDeVenta;
	private LocalTime hora;
	private LocalTime fecha;
	
	public Venta(PuntoDeVenta puntoDeVenta, LocalTime hora, LocalTime fecha) {
		this.puntoDeVenta = puntoDeVenta;
		this.hora = hora;
		this.fecha  = fecha;
		this.nroDeControl = this.generarNumeroDeControl();
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
	

	

}

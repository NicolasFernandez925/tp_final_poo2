package sem_venta;

import java.time.LocalDate;
import java.time.LocalTime;

import sem_PuntoDeVenta.PuntoDeVenta;

public abstract class Venta {
	private int nroDeControl = 0;
	@SuppressWarnings("unused")
	private PuntoDeVenta puntoDeVenta;
	private LocalTime hora;
	private LocalDate fecha;
	
	public Venta(PuntoDeVenta puntoDeVenta, LocalTime hora, LocalDate fecha) {
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
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	

	

}

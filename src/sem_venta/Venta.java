package sem_venta;

import java.time.LocalDate;
import java.time.LocalTime;

import sem_PuntoDeVenta.PuntoDeVenta;

public abstract class Venta {
	private int nroDeControl;
	@SuppressWarnings("unused")
	private PuntoDeVenta puntoDeVenta;
	private LocalTime hora;
	private LocalDate fecha;


	public Venta(PuntoDeVenta puntoDeVenta, LocalTime hora, LocalDate fecha) {
		this.puntoDeVenta = puntoDeVenta;
		this.hora = LocalTime.now();
		this.fecha  = LocalDate.now();
		this.nroDeControl =  Numerador.siguienteNroDeControl();
	}
	
	public LocalTime getHora() {
		return this.hora;
	}
	
	public int getNroControl() {
		return this.nroDeControl;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	//Metodo para testear
	public int getNroDeControl() {
		return nroDeControl;
	}

	

}

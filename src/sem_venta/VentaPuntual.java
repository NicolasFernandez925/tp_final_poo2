package sem_venta;

import java.time.LocalTime;

import sem_PuntoDeVenta.PuntoDeVenta;

public class VentaPuntual extends Venta {
	private int horas;
	private String patente;
	
	public VentaPuntual(int horasCompradas, String nroPatente, PuntoDeVenta puntoDeVenta, LocalTime hora, LocalTime fecha) {
		super(puntoDeVenta, hora, fecha);
		this.horas = horasCompradas;
		this.patente = nroPatente;
	}

	public int getCantidadDeHoras() {
		return this.horas;
	}
}

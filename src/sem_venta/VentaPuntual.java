package sem_venta;

import sem_PuntoDeVenta.PuntoDeVenta;

public class VentaPuntual extends Venta {
	private int horas;
	private String patente;
	
	public VentaPuntual(int horasCompradas, String nroPatente, PuntoDeVenta puntoDeVenta) {
		super(puntoDeVenta);
		this.horas = horasCompradas;
		this.patente = nroPatente;
	}

	public int getCantidadDeHoras() {
		return this.horas;
	}
}

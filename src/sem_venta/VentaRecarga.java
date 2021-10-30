package sem_venta;

import java.time.LocalTime;

import sem_PuntoDeVenta.PuntoDeVenta;

public class VentaRecarga extends Venta {
	
	private int nroCelular;
	private double monto;
	
	public VentaRecarga(int celular, double monto, PuntoDeVenta puntoDeVenta, LocalTime hora, LocalTime fecha) {
		super(puntoDeVenta, hora, fecha);
		this.nroCelular = celular;
		this.monto = monto;
	}
	
	public double getMonto() {
		return this.monto;
	}
	
}

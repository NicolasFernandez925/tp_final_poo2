package sem_venta;

import sem_PuntoDeVenta.PuntoDeVenta;

public class VentaRecarga extends Venta {
	
	private int nroCelular;
	private double monto;
	
	public VentaRecarga(int celular, double monto, PuntoDeVenta puntoDeVenta) {
		super(puntoDeVenta);
		this.nroCelular = celular;
		this.monto = monto;
	}
	
	public double getMonto() {
		return this.monto;
	}
	public double getNroCelular() {
		return this.nroCelular;
	}
	
}

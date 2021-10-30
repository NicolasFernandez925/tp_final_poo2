package sem_PuntoDeVenta;

import sem_venta.Venta;

public interface ISEMPuntoDeVenta {
	public void venderHoras(int horas);
	public void hacerRecarga(int nroCelular, int monto);
	public void registrarVenta(Venta venta);
}

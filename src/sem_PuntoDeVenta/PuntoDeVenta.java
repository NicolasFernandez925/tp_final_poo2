package sem_PuntoDeVenta;

import java.util.ArrayList;

import sem_venta.Venta;
import sem_venta.VentaPuntual;
import sem_venta.VentaRecarga;

public class PuntoDeVenta implements ISEMPuntoDeVenta{
	private int coordenada;
	private int id;
	private ArrayList<VentaRecarga> recargas; 
	private ArrayList<VentaPuntual> ventasPuntuales; 
	
	public PuntoDeVenta(int id, int coordenada) {
		this.id = id;
		this.coordenada = coordenada;
	}

	@Override
	public void venderHoras(int horas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hacerRecarga(int nroCelular, int monto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarVenta(Venta venta) {
		// TODO Auto-generated method stub
		
	}
	
	public int getCoordenada() {
		return this.coordenada;
	}
	
	
	public int totalDeHorasVendidas() {
	
		return ventasPuntuales.stream().mapToInt(VentaPuntual::getHoras).sum(); 
	}
	
	public double totalMontoDeRecargas() {
		return 1;
	}
	

}

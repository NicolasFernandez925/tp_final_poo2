package sem_PuntoDeVenta;

import java.util.ArrayList;

import sem_venta.Venta;
import sem_venta.VentaPuntual;
import sem_venta.VentaRecarga;

public class PuntoDeVenta implements ISEMPuntoDeVenta{
	private int coordenada;
	private int id;
	// Aca podria ser una lista de tipo venta, en vez que haya 2 arrays tanto para recargas
	// como para ventas puntuales. Los metodos 
	private ArrayList<Venta> ventas; 
	//private ArrayList<VentaRecarga> recargas; 
	//private ArrayList<VentaPuntual> ventasPuntuales; 
	
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
	
	// Estos metodos  podrian quitarse ya que fueron opcionales, no los pide el TP
	// ademas que eso nos complica para calcularlo ya que se plante solo tener un array de Ventas y no 
	// de c/u
	/*public int totalDeHorasVendidas() {
	
		return ventasPuntuales.stream().mapToInt(VentaPuntual::getCantidadDeHoras).sum(); 
	}
	
	public double totalMontoDeRecargas() {
		return 1;
	}
	*/
	

}

package sem_PuntoDeVenta;

import java.util.ArrayList;

import sem_venta.Numerador;
import sem_venta.Venta;
import sem_venta.VentaPuntual;
import sem_venta.VentaRecarga;

public class PuntoDeVenta implements ISEMPuntoDeVenta{
	private int coordenada;
	private int id;
	private Numerador numerador;
	private ArrayList<Venta> ventas; 

	
	public PuntoDeVenta(int id, int coordenada) {
		this.id = id;
		this.coordenada = coordenada;
		this.numerador = new Numerador();
	}

	@Override
	public void venderHoras(int horas) {
		// TODO Auto-generated method stub
		//GestorSEM Generar estacionamiento pUtual
		
	}

	@Override
	public void hacerRecarga(int nroCelular, int monto) {
		//TODO: llamar al celular para recargar(nro, monto) y GestorSEM actualizar. Llamar a registrarVenta
		VentaRecarga venta = new VentaRecarga(nroCelular, monto, this, this.asignarSiguienteNroDeControl());

	}

	@Override
	public void registrarVenta(Venta venta) {
		// TODO Auto-generated method stub
		//Agregar venta a la lista.
		this.ventas.add(venta);
		
	}
	
	public int getCoordenada() {
		return this.coordenada;
	}

	public int asignarSiguienteNroDeControl() {
		return numerador.siguienteNroDeControl();
	}

}

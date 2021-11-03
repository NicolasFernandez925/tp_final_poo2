package sem_PuntoDeVenta;


import java.util.ArrayList;

import sem.IGestorSem;
import sem_celular.ISemCelular;
import sem_numerador.Numerador;
import sem_venta.Venta;
import sem_venta.VentaPuntual;
import sem_venta.VentaRecarga;

public class PuntoDeVenta implements ISEMPuntoDeVenta{
	private int coordenada;
	private Numerador numerador;
	private ArrayList<Venta> ventas; 
	private IGestorSem gestor;
	private ISemCelular celular;

	
	public PuntoDeVenta(int coordenada, IGestorSem gestor, ISemCelular celular) {
		this.coordenada = coordenada;
		this.numerador = new Numerador();
		this.gestor = gestor;
		this.celular = celular;
		this.ventas = new ArrayList<Venta>();
	}

	@Override
	public void venderHoras(int horas, int puntoGeografico, String nroPatente) {
		this.gestor.getGestorSem().generarEstacionamientoPuntual(nroPatente, puntoGeografico, horas);
		Venta venta = new VentaPuntual(horas, nroPatente, this, this.asignarSiguienteNroDeControl());
		this.registrarVenta(venta);
		
	}

	@Override
	public void hacerRecarga(int monto, int nroCelular) {
		this.celular.recargarSaldo(monto, nroCelular); 
		this.gestor.getGestorSem().actualizarHorarioEstacionamiento(nroCelular, monto);
		VentaRecarga venta = new VentaRecarga(nroCelular, monto, this, this.asignarSiguienteNroDeControl());
		this.registrarVenta(venta);
	}

	@Override
	public void registrarVenta(Venta venta) {
		this.ventas.add(venta);
		
	}
	
	public int getCoordenada() {
		return this.coordenada;
	}

	public int asignarSiguienteNroDeControl() {
		return numerador.siguienteNumero();
	}

	@Override
	public ArrayList<Venta> getVentas() {
		return this.ventas;
	}

}

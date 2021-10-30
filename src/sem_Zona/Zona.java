package sem_Zona;
import java.util.ArrayList;
import java.util.Random;

import sem_Inspector.*;
import sem_PuntoDeVenta.*;
import sem_estacionamiento.*;


public class Zona {
	private ArrayList<Estacionamiento> estacionamientos;
	private ArrayList<ISEMPuntoDeVenta> puntosDeVenta;
	private ArrayList<Integer> puntosGeograficos;
	private Inspector inspector;
	
	public Zona(){
		this.estacionamientos = new ArrayList<Estacionamiento>();
		this.puntosDeVenta = new ArrayList<ISEMPuntoDeVenta>();
		this.puntosGeograficos = new ArrayList<Integer>();

	}
	
	public int cantidadDeEstacionamientos() {
		return this.estacionamientos.size();
	}

	public void registrarInspector(Inspector inspector) {
		this.inspector = inspector;
	}
	
	public Inspector getInspector() {
		return this.inspector;
	}
	
	public ArrayList<Estacionamiento> getEstacionamientos(){
		return this.estacionamientos;
	}
	
	public ArrayList<ISEMPuntoDeVenta> getPuntosDeVenta() {
		return this.puntosDeVenta;
	}
	
	public void registrarPuntoDeVenta(ISEMPuntoDeVenta puntoDeVenta) {
		this.puntosDeVenta.add(puntoDeVenta);
	}
	
	public ArrayList<Integer> getPuntosGeograficos(){
		return this.puntosGeograficos;
	}
	
	public void setPuntosGeograficos(ArrayList<Integer> puntos) {
		this.puntosGeograficos = puntos;
	}
	public void registrarPuntoGeografico(int puntoGeografico) {
		this.puntosGeograficos.add(puntoGeografico);
	}
	
	public boolean contienePuntoGeografico(int puntoGeografico) {
		return this.puntosGeograficos.contains(puntoGeografico);
	}
	
	public ISEMPuntoDeVenta getPuntoDeVentaRandom() {
		//precondicion: tiene que haber algun puto de venta.
		Random random = new Random();
		int randomSelector = random.nextInt(this.puntosDeVenta.size());
		return this.puntosDeVenta.get(randomSelector);
	}
	
	public void registrarEstacionamiento(Estacionamiento _estacionamiento) {
		this.estacionamientos.add(_estacionamiento);
	}

	public boolean tieneEstacionamientoVigente(String nroDePatente) {
		return this.estacionamientos.stream().anyMatch( e -> e.getPatente() == nroDePatente && e.estacionamientoVigente());		
	}

	public boolean tieneAsignadoElInspector(int idInspector) {
		return idInspector == inspector.getId();
	}
}
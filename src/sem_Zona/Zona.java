package sem_Zona;
import java.util.ArrayList;
import java.util.Random;

import sem_Inspector.*;
import sem_PuntoDeVenta.*;
import sem_estacionamiento.*;


public class Zona {
	private ArrayList<Estacionamiento> estacionamientos;
	private ArrayList<PuntoDeVenta> puntosDeVenta;
	private ArrayList<Integer> puntosGeograficos;
	
	public Zona(){
		this.estacionamientos = new ArrayList<Estacionamiento>();
		this.puntosDeVenta = new ArrayList<PuntoDeVenta>();
		this.puntosGeograficos = new ArrayList<Integer>();
	}
	
	public int cantidadDeEstacionamientos() {
		return this.estacionamientos.size();
	}

	public void registrarInspector(Inspector inspector) {
		
	}
	
	public ArrayList<Estacionamiento> getEstacionamientos(){
		return this.estacionamientos;
	}
	
	public ArrayList<PuntoDeVenta> getPuntosDeVenta() {
		return this.puntosDeVenta;
	}
	
	public void registrarPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
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
	
	public PuntoDeVenta getPuntoDeVentaRandom() {
		Random random = new Random();
		int randomSelector = random.nextInt(this.puntosDeVenta.size());
		return this.puntosDeVenta.get(randomSelector);
	}
	
	public void registrarEstacionamiento(Estacionamiento _estacionamiento) {
		this.estacionamientos.add(_estacionamiento);
	}

	public boolean tieneEstacionamientoVigente(String nroDePatente) {
		// TODO Auto-generated method stub
		Estacionamiento estacionamiento = this.estacionamientos.stream().filter(e -> e.getPatente() == nroDePatente).findFirst().get();
		return estacionamiento.estacionamientoVigente() ? true : false;
		
	}
	
	

	
	
}
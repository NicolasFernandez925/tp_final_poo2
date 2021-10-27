package sem_Zona;
import java.util.ArrayList;
import java.util.Random;

import estacionamiento.*;
import sem_Inspector.*;
import sem_PuntoDeVenta.*;


public class Zona {
	private ArrayList<Estacionamiento> estacionamientos;
	private ArrayList<PuntoDeVenta> puntosDeVenta;
	private ArrayList<Integer> puntosGeograficos;
	
	public Zona(){};
	
	public int cantidadDeEstacionamientos() {
		return this.estacionamientos.size();
	}

	public boolean tieneEstacionamiento(String patente) {
		// TODO Auto-generated method stub
		return this.estacionamientos.contains(patente);
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
	
	public void setPuntosGeograficos(int puntoGeografico) {
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
	
	

	
	
}
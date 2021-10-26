package Sem_Zona;
import java.util.ArrayList;

import Estacionamiento.*;
import PuntoDeVenta.*;

public class Zona {
	private ArrayList<Estacionamiento> estacionamientos;
	private ArrayList<PuntoDeVenta> puntosDeVenta;
	private ArrayList<Integer> puntosGeograficos;
	
	public Zona(){};
	
	public int cantidadDeEstacionamientos() {
		return 1;
	}

	public boolean tieneEstacionamiento(String patente) {
		// TODO Auto-generated method stub
		return false;
	}
}

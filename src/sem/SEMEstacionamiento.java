package sem;
import java.util.ArrayList;
import java.util.List;

import sem_Zona.Zona;
import sem_estacionamiento.Estacionamiento;

public class SEMEstacionamiento implements ISemEstacionamiento {
	private ArrayList<Zona> zonas;
	
	public SEMEstacionamiento(){
		this.zonas = new ArrayList<Zona>();
	};
	
	public void agregarZona(Zona _zona) {
		this.zonas.add(_zona);
	}
	
	public boolean tieneEstacionamientoVigente(String nroDePatente) {
		return this.zonas.stream().anyMatch(zona -> zona.tieneEstacionamientoVigente(nroDePatente));
	}
	

	@Override
	public Estacionamiento buscarEstacionamientoVigente(int nroCelular) throws Exception {
		for(Zona zona : this.getZonas()) {
			for(Estacionamiento e : zona.getEstacionamientos()) {
				if(e.estacionamientoVigente() && e.sonNumerosIguales(nroCelular)) {
					return e;
				}
			}
		}
		
		throw new Exception("No se encontro el estacionamiento con el numero de celular asocionado con: " + nroCelular );
		
	}
	
	public int cantidadDeEstacionamientos() {
		return  this.zonas.stream().map(Zona :: cantidadDeEstacionamientos).reduce(0, (subtotal, valor) -> subtotal + valor);
	}
	
	public int cantidadDeZonas() {
		return (int) this.zonas.stream().count();
	}
	
	public Zona getPuntoDeVentaEnLaZonaMasCercana(int coordenada) {
		return null;
	}

	@Override
	public List<Zona> getZonas() {
		// TODO Auto-generated method stub
		return this.zonas;
	}

	@Override
	public void finalizarEstacionamientos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estaDentroDeUnaZonaConLaCoordenada(int coordenada) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estaEnElMismoPuntoGeograficoDeInicioEstcaiomiento(int coordenada) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Precondicion : Se debe haber cargado previamente almenos 1 zona en el SEM.
	 * */

	@Override
	public void registrarEstacionamiento(Estacionamiento e) {
		Zona zonaRandom = zonas.get(0);
		zonaRandom.registrarEstacionamiento(e);		
	}
}

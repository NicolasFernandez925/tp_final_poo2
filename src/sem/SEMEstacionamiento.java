package sem;

import java.time.LocalTime;
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
	
	/**
	 * @param nroDePatente : String
	 * @return retorna un Boolean si en alguna zona tiene el estacionamiento valido
	 * Este metodo se usa para que el Inspector busque a travez de la patente si esta viegente o no 
	 * */
	public boolean tieneEstacionamientoVigente(String nroDePatente) {
		return this.zonas.stream().anyMatch(zona -> zona.tieneEstacionamientoVigente(nroDePatente));
	}
	
	/**
	 * @param nroDePatente : String
	 * @param idInspector : ID que representa al inspector en una zona "x"
	 * @return retorna un booleano indicando si en alguna de las zonas del inspector hay un estacionamiento valido
	 * Precondicion: El inspector con el ID dado tiene asignado una zona
	 * */
	public boolean consultarEstacionamiento(String nroPatente, int idInspector) {
		Zona zona = this.getZonas().stream().filter(z -> z.tieneAsignadoElInspector(idInspector)).findFirst().get();
		return zona.getEstacionamientos().stream().anyMatch(e -> e.estacionamientoVigente() && e.getPatente() == nroPatente);
	}
	
	/**
	 * @param nroDePatente : String
	 * @return Retorna un Estacionamiento luego de buscar en todas las zonas el estacionamiento vigente
	 * registrado con el nroCelular dado. En caso que no encuentre un estacionamiento lanza una Exception.
	 * */
	@Override
	public Estacionamiento buscarEstacionamientoVigente(int nroCelular) throws Exception {
		List<Estacionamiento> estacionamientos = this.todosLosEstacionamientos();
		for(Estacionamiento e : estacionamientos) {
			if(e.estacionamientoVigente() && e.sonNumerosIguales(nroCelular)) {
				return e;
			}
		}	
		throw new Exception("No se encontro un estacionamiento vigente con el numero de celular asocionado con: " + nroCelular );	
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
		return this.zonas;
	}

	@Override
	public void finalizarTodosLosEstacionamientos(LocalTime horaFinDeJornada) {
		List<Estacionamiento> estacionamientos = this.todosLosEstacionamientos();		
		for(Estacionamiento e : estacionamientos) {
			if(e.estacionamientoVigente()) {
				e.finalizar(horaFinDeJornada);
			}			
		}	
	}
	
	private List<Estacionamiento> todosLosEstacionamientos() {
		List<Estacionamiento> estacionamientos = new ArrayList<Estacionamiento>();
		this.getZonas().stream().forEach(e -> estacionamientos.addAll(e.getEstacionamientos()));		
		return estacionamientos;
	}

	@Override
	public boolean estaDentroDeUnaZonaConLaCoordenada(int coordenada) {
		// TODO Falta implementar
		return false;
	}

	@Override
	public boolean estaEnElMismoPuntoGeograficoDeInicioEstcaiomiento(int coordenada) {
		// TODO Falta implementar
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

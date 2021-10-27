package sem;
import sem_Zona.Zona;
import sem_estacionamiento.Estacionamiento;

import java.util.List;


public interface ISemEstacionamiento {
	public void agregarZona(Zona zona);
	public List<Zona> getZonas();
	public void finalizarEstacionamientos();
	public boolean estaDentroDeUnaZonaConLaCoordenada(int coordenada);
	public boolean estaEnElMismoPuntoGeograficoDeInicioEstcaiomiento(int coordenada);
	public void registrarEstacionamiento(Estacionamiento e);
	public Estacionamiento buscarEstacionamientoVigente(int nroCelular) throws Exception;
	public boolean tieneEstacionamientoVigente(String patente);
}

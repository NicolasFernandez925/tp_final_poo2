package Sem_Estacionamiento;

public class GestorSem {

	public Boolean tieneEstacionamientoVigente() {
		return false;
	}
	
	public Boolean estaDentroDeUnaZonaConLaCoordenada(int coordenada) {
		return true;
	}
	
	public Boolean estaEnElMismoPuntoGeograficoDeInicioEstcaiomiento(int coordenada) {
		return false;
	}
	
	public String iniciarEstacionamiento(String patente) {
		return "";
	}
	public Boolean seEncuentraEnZonaElUsuario(int coordenada) {
		return true;
	}
	
	public String finalizarEstacionamiento() {
		return "";
	}
}

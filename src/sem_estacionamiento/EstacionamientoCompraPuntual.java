package sem_estacionamiento;

import java.time.LocalTime;

public class EstacionamientoCompraPuntual extends Estacionamiento {

	private int cantidadDeHoras;

	public EstacionamientoCompraPuntual(String patente, LocalTime horaFinal, int puntoGeografico, int horas) {
		super(patente, horaFinal, puntoGeografico);		
		this.cantidadDeHoras = horas;		
	}
	
	@Override
	public Boolean estacionamientoVigente() {
		return this.getHoraDeFinalizacion().isAfter(LocalTime.now());
	}
	
	public int getCantidadDeHoras() {
		return cantidadDeHoras;
	}

	@Override
	public Boolean sonNumerosIguales(int nroCelular) {
		return false;
	}



}

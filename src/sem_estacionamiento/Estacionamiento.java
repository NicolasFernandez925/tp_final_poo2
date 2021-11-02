package sem_estacionamiento;

import java.time.LocalTime;

public abstract class Estacionamiento {
	private LocalTime horaDeInicio;	
	private LocalTime horaDeFinalizacion;
	private String patente;
	private int puntoGeografico;
	
	public Estacionamiento(String patente, LocalTime horaFinal, int puntoGeografico) {
		this.patente = patente;
		this.horaDeInicio = LocalTime.now();
		this.horaDeFinalizacion = horaFinal;
		this.puntoGeografico = puntoGeografico;
	}
	
	public abstract Boolean estacionamientoVigente();
	public abstract Boolean sonNumerosIguales(int nroCelular);
	
	// Method HOOK
	public void finalizar(LocalTime horaFin) {}
	
	
	public LocalTime getHoraDeInicio() {
		return horaDeInicio;
	}

	public void setHoraDeInicio(LocalTime horaDeInicio) {
		this.horaDeInicio = horaDeInicio;
	}

	public LocalTime getHoraDeFinalizacion() {
		return horaDeFinalizacion;
	}

	public void setHoraDeFinalizacion(LocalTime horaDeFinalizacion) {
		this.horaDeFinalizacion = horaDeFinalizacion;
	}

	public String getPatente() {
		return this.patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public int getPuntoGeografico() {
		// TODO Auto-generated method stub
		return this.puntoGeografico;
	}


}

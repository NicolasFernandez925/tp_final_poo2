package Estacionamiento;

import java.time.LocalTime;

public abstract class Estacionamiento {
	private LocalTime horaDeInicio;	
	private LocalTime horaDeFinalizacion;
	private String patente;
	
	public Estacionamiento(String patente, LocalTime horafinal) {
		this.patente = patente;
		this.horaDeInicio = LocalTime.now();
		this.horaDeFinalizacion = horafinal;
	}
	
	public abstract Boolean estacionamientoVigente();
	
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
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}


}

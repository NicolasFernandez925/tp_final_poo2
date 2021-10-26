package system;

import java.time.LocalTime;

public class Estacionamiento {
	private LocalTime horaDeInicio;
	private LocalTime horaDeFinalizacion;
	private String patente;
	
	public Estacionamiento( String patente) {
		this.horaDeInicio = LocalTime.now();
		// this.horaDeFinalizacion = ;		
		this.patente = patente ;
	}
	
	public boolean estaDentroDelHorarioDeFuncionamiento(LocalTime hora) {
		return false;
	}
	
	public boolean esEstacionamientoVigente(LocalTime hora) {
		return false;
	}
	
	public void establecerHoraFinEstacionamiento(LocalTime fin) {
		
	}
	
	public LocalTime getHoraDeInicio() {
		return this.horaDeInicio;
	}
	
	public LocalTime getHoraDeFinalizacion(){
		return this.horaDeFinalizacion;
	}
	
	public String getPatente() {
		return this.patente;
	}
	
	public void setHoraDeInicio(LocalTime inicio) {
		
	}
	
	public void setHoraDeFinalizacion(LocalTime fin) {
		
	}
}

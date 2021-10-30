package sem_multa;

import java.time.LocalDate;
import java.time.LocalTime;

import sem_Zona.Zona;

public class Multa {
	private int idInspector;
	private LocalTime hora;
	private LocalDate fecha;
	private String patente;
	private Zona zona;
	
	public Multa(String patente, Zona zona, int idInspector) {
		super();
		this.patente = patente;
		this.idInspector = idInspector;
		this.hora = LocalTime.now();
		this.fecha = LocalDate.now();
		this.zona = zona;
	}

	public Zona getZona() {
		return zona;
	}
	
	public int getIdInspector() {
		return idInspector;
	}

	public LocalTime getHora() {
		return hora;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	public String getPatente() {
		return patente;
	}
}

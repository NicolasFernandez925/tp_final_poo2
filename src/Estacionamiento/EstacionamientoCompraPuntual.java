package Estacionamiento;

import java.time.LocalTime;

public class EstacionamientoCompraPuntual extends Estacionamiento {

	private int cantidadDeHoras;

	public EstacionamientoCompraPuntual(String patente, int horas, LocalTime horaFinal) {
		super(patente, horaFinal);
		this.cantidadDeHoras = horas;		
	}

	@Override
	public Boolean estacionamientoVigente() {
		return this.getHoraDeFinalizacion().isAfter(LocalTime.now());
	}
	
	public int getCantidadDeHoras() {
		return cantidadDeHoras;
	}

	/**
	 * No hace nada, porque el finalizar de un estacionamiento puntual lo establece en el ticket al momento
	 * de la compra de horas
	 * */
	@Override
	public void finalizar(LocalTime horaFin) {
		// TODO Auto-generated method stub	
	}

}

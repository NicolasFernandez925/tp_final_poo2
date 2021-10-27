package sem;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import sem_estacionamiento.Estacionamiento;
import sem_estacionamiento.EstacionamientoCompraApp;
import sem_estacionamiento.EstacionamientoCompraPuntual;

public class GestorSem {

	private LocalTime inicioDeJornada;
	private LocalTime finDeJornada;
	private LocalTime horaFinal;
	private double costoPorHora;
	private ISemEstacionamiento semEstacionamiento;
	
	public GestorSem(ISemEstacionamiento semEstacionamiento) {
		this.costoPorHora = 40;
		this.inicioDeJornada = LocalTime.of(07, 00);
		this.finDeJornada = LocalTime.of(20, 00);
		this.semEstacionamiento = semEstacionamiento;
	}

	public Boolean tieneEstacionamientoVigente(String nroPatente) {
		return semEstacionamiento.tieneEstacionamientoVigente(nroPatente);
	}
	
	public Boolean estaDentroDeUnaZonaConLaCoordenada(int coordenada) {
		// TODO Falta implementar
		return true;
	}
	
	public Boolean estaEnElMismoPuntoGeograficoDeInicioEstcaiomiento(int coordenada) {
		// TODO Falta implementar
		return false;
	}
	
	/**
	 * @param patente: String 
	 * @param saldoDisponible: Double
	 * @return Un String que representa al msg describiendo los datos del inicio del estcionamiento
	 * */
	
	public String iniciarEstacionamiento(String patente, double saldoDisponible,int nroCelular) {
		LocalTime horaMaximaDeFin;
		if(saldoDisponible > 0) {			
			horaMaximaDeFin = this.calcularTiempoMaximo(saldoDisponible, LocalTime.now());		
			this.getSemEstacionamiento().registrarEstacionamiento(new EstacionamientoCompraApp(patente, nroCelular, horaMaxima));	
			//FALTA IMPLEMENTAR EL MSG DETALLANDO CADA OPERACION DEL INICIO DEL ESTACIONAMIENTO
			return this.notificacionInicioDeEstacionamiento(LocalTime.now(), horaMaximaDeFin);
		}
		else {
			return "Saldo insuficiente. Estacionamiento no permitido.";
		}
	}
	
	/**
	 * @param saldoDisponible: double 
	 * @param horaActual: LocalTime
	 * @return Un LocalTime indicando la hora final del estacionamiento, caso contrario sino esta
	 * en la franja horaria la hora final de la jornada.
	 * */
	
	private  LocalTime calcularTiempoMaximo(double saldoDisponible, LocalTime horaActual) {
		long minutosDisponibles = (long)this.cantidadDeMinutosDisponibles(saldoDisponible);
		LocalTime result = horaActual.plusMinutes(minutosDisponibles);
		return this.estaDentroDeFranjaHoraria(result) ? result : this.getInicioDeJornada();
	}
	
	private double cantidadDeMinutosDisponibles(double saldo) {
		return saldo / this.precioPorMinuto();
	}
	
	private double precioPorMinuto() {
		double valorMinuto = this.getCostoPorHora() / 60;
		double roundDbl = Math.round(valorMinuto *100.0)/100.0;
		return roundDbl;
	}

	/**
	 * @param patente: Un String
	 * @param cantidadDeHoras: Un Integer
	 * */

	public void generarEstacionamientoPuntual(String patente, int cantidadDeHoras) {
		horaFinal = LocalTime.now().plusHours(cantidadDeHoras);
		if(this.estaDentroDeFranjaHoraria(horaFinal)) {
			semEstacionamiento.registrarEstacionamiento(new EstacionamientoCompraPuntual(patente,cantidadDeHoras, horaFinal));	
		}
		else {
			horaFinal =  this.getFinDeJornada();
			semEstacionamiento.registrarEstacionamiento(new EstacionamientoCompraPuntual(patente,cantidadDeHoras, horaFinal));
		}
	}
	
	private boolean estaDentroDeFranjaHoraria(LocalTime horaMaxima) {
		return this.getInicioDeJornada().isBefore(horaMaxima) && this.getFinDeJornada().isAfter(horaMaxima);
	}

	public Boolean seEncuentraEnZonaElUsuario(int coordenada) {
		return true;
	}
	
	/**
	 * @param nroCelular : Integer
	 * @return Un string con los detalles del estacionamiento
	 * Nota: Puede lanzar Error al no encontrar un estacionamiento vinculado al nroCelular
	 * */
	public String finalizarEstacionamiento(int nroCelular){
		LocalTime horaDeFinalizacion = LocalTime.now();
		try {
			Estacionamiento e = semEstacionamiento.buscarEstacionamientoVigente(nroCelular);
			e.finalizar(horaDeFinalizacion);
			long minutosConsumidos = this.totalMinutos(e.getHoraDeInicio(), e.getHoraDeFinalizacion());
			LocalTime horasConsumidas = this.tiempoTotalEnHorasConsumidas(minutosConsumidos);
			double costo = this.costoEstacionamiento(e.getHoraDeInicio(), e.getHoraDeFinalizacion());
			return this.notificacionFinalizacionDeEstacionamiento(horasConsumidas, e, costo);
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}
	
	public void finalizarTodosLosEstacionamientos() {
		semEstacionamiento.finalizarTodosLosEstacionamientos(this.getFinDeJornada());
	}
	
	private long totalMinutos(LocalTime horaInicio, LocalTime horaFin) {
		return horaInicio.until(horaFin, ChronoUnit.MINUTES);
	}
	
	private double costoEstacionamiento(LocalTime horaInicio, LocalTime horaFin) {
		return this.totalMinutos(horaInicio, horaFin) * this.precioPorMinuto();
	}

	public String notificacionFinalizacionDeEstacionamiento(LocalTime horasConsumidas, Estacionamiento e, double costo) {
		return "Hora de Inicio: " + e.getHoraDeInicio() + " /n " +
	           "Hora de Finalización: " + e.getHoraDeFinalizacion() + " /n " +
	           "Duracion: " + horasConsumidas + " /n " +
	           "Costo " + costo;
	}
	
	public String notificacionInicioDeEstacionamiento(LocalTime horaDeInicio, LocalTime horaMaximaDeFinalizacion) {
		return "Hora de Inicio: " + horaDeInicio + " /n " +
	           "Hora de Finalización: " + horaMaximaDeFinalizacion;
	}

	private LocalTime tiempoTotalEnHorasConsumidas(long minutos) {
		LocalTime time = LocalTime.of(00, 00); 
		return time.plusMinutes(minutos);
	}

	public LocalTime getInicioDeJornada() {
		return inicioDeJornada;
	}

	public LocalTime getFinDeJornada() {
		return finDeJornada;
	}

	public double getCostoPorHora() {
		return costoPorHora;
	}

	public ISemEstacionamiento getSemEstacionamiento() {
		return semEstacionamiento;
	}
	public LocalTime getHoraFinal() {
		return this.horaFinal;
	}
	

	public void setInicioDeJornada(LocalTime inicioDeJornada) {
		this.inicioDeJornada = inicioDeJornada;
	}

	public void setSemEstacionamiento(ISemEstacionamiento semEstacionamiento) {
		this.semEstacionamiento = semEstacionamiento;
	}

}

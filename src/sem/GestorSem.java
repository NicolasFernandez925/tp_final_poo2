package sem;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import sem_celular.ISemCelular;
import sem_estacionamiento.Estacionamiento;
import sem_estacionamiento.EstacionamientoCompraApp;
import sem_estacionamiento.EstacionamientoCompraPuntual;
import sem_notificacion.INotificacion;
import sem_notificacion.NotificacionAlertaConsultaDeSaldo;
import sem_notificacion.NotificacionError;
import sem_notificacion.NotificacionFinalizacionEstacionamiento;
import sem_notificacion.NotificacionInicioDeEstacionamiento;
import sem_alarmas.IObserver;
import sem_alarmas.ISubject;

public class GestorSem implements IGestorSem, ISubject{

	private LocalTime inicioDeJornada;
	private LocalTime finDeJornada;
	private LocalTime horaFinal;
	private double costoPorHora;
	private ISemEstacionamiento semEstacionamiento;
	private ISemCelular celular;
	private ArrayList<IObserver> subscriptores;
	
	
	public GestorSem(ISemEstacionamiento semEstacionamiento, ISemCelular celular) {
		this.costoPorHora = 40;
		this.inicioDeJornada = LocalTime.of(07, 00);
		this.finDeJornada = LocalTime.of(20, 00);
		this.semEstacionamiento = semEstacionamiento;
		this.celular = celular;
		this.subscriptores = new ArrayList<IObserver>();
	}

	public Boolean tieneEstacionamientoVigente(String nroPatente) {
		return semEstacionamiento.tieneEstacionamientoVigente(nroPatente);
	}

	public Boolean estaDentroDeUnaZonaConLaCoordenada(int coordenada) {
		return semEstacionamiento.estaDentroDeUnaZonaConLaCoordenada(coordenada);
	}
	
	public Boolean estaEnElMismoPuntoGeograficoDeInicioEstaciomiento(int coordenada, String nroPatente) {
		return semEstacionamiento.estaEnElMismoPuntoGeograficoDeInicioEstaciomiento(coordenada, nroPatente);
	}
	
	/**
	 * @param patente: String 
	 * @param saldoDisponible: Double
	 * @return Un String que representa al msg describiendo los datos del inicio del estcionamiento
	 * */
	
	public INotificacion iniciarEstacionamiento(String patente,int nroCelular,int puntoGeografico) {
		LocalTime horaMaximaDeFin;
		LocalTime horaActual = LocalTime.now();
		if(celular.consultarSaldo(nroCelular) > 0) {		
			horaMaximaDeFin = this.calcularTiempoMaximo(celular.consultarSaldo(nroCelular), LocalTime.now());		
			this.getSemEstacionamiento().registrarEstacionamiento(new EstacionamientoCompraApp(patente,horaMaximaDeFin, nroCelular, puntoGeografico));
			INotificacion notificacion = new NotificacionInicioDeEstacionamiento(horaActual, horaMaximaDeFin);
			this.notificarInicioEstacionamiento(notificacion);
			return notificacion;
		}
		else {
			return new NotificacionError("Saldo insuficiente. Estacionamiento no permitido.");
		}
	}
	
	/**
	 * @param saldoDisponible: double 
	 * @param horaActual: LocalTime
	 * @return Un LocalTime indicando la hora final del estacionamiento, caso contrario sino esta
	 * en la franja horaria la hora final de la jornada.
	 * */
	
	private LocalTime calcularTiempoMaximo(double saldoDisponible, LocalTime horaActual) {
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

	public void generarEstacionamientoPuntual(String patente,int puntoGeografico, int cantidadDeHoras) {
		horaFinal = LocalTime.now().plusHours(cantidadDeHoras);
		if(this.estaDentroDeFranjaHoraria(horaFinal)) {
			semEstacionamiento.registrarEstacionamiento(new EstacionamientoCompraPuntual(patente, horaFinal, puntoGeografico, cantidadDeHoras));	
		}
		else {
			horaFinal =  this.getFinDeJornada();
			semEstacionamiento.registrarEstacionamiento(new EstacionamientoCompraPuntual(patente, horaFinal, puntoGeografico, cantidadDeHoras));
		}
	}

	private boolean estaDentroDeFranjaHoraria(LocalTime horaMaxima) {
		return this.getInicioDeJornada().isBefore(horaMaxima) && this.getFinDeJornada().isAfter(horaMaxima);
	}
	
	/**
	 * @param nroCelular : Integer
	 * @return Un string con los detalles del estacionamiento
	 * Nota: Puede lanzar Error al no encontrar un estacionamiento vinculado al nroCelular
	 * */
	public INotificacion finalizarEstacionamiento(int nroCelular){
		LocalTime horaDeFinalizacion = LocalTime.now();
		try {
			Estacionamiento e = semEstacionamiento.buscarEstacionamientoVigente(nroCelular);
			e.finalizar(horaDeFinalizacion);
			long minutosConsumidos = this.totalMinutos(e.getHoraDeInicio(), e.getHoraDeFinalizacion());
			LocalTime horasConsumidas = this.tiempoTotalEnHorasConsumidas(minutosConsumidos);	
			double costo = this.costoEstacionamiento(e.getHoraDeInicio(), e.getHoraDeFinalizacion());
			celular.descontarSaldo(nroCelular, costo);
			INotificacion notificacion = new NotificacionFinalizacionEstacionamiento(horasConsumidas, e.getHoraDeInicio(), e.getHoraDeFinalizacion(), costo);
			this.notificarInicioEstacionamiento(notificacion);
			return notificacion;
		} catch (Exception e) {
		  return new NotificacionError(e.getMessage());
		}
		
	}
	
	/**
	 * @param nroCelular es el numero del celular en el cual se hizo una recarga.
	 * montoCargado es el monto de carga que luego se utiliza para calcular la cantidad
	 * el equivalente en minutos
	 * 
	 * Nota: Este metodo actualiza el horario MAXIMO cuando se realiza una recarga desde un punto de venta
	 * para un estacionamiento via App que YA SE ENCUENTRA INICIADO.
	 * */
	
	public void actualizarHorarioEstacionamiento(int nroCelular, double montoCargado) {
		try {
			Estacionamiento e = semEstacionamiento.buscarEstacionamientoVigente(nroCelular);
			LocalTime horaMaximaDeFin = this.calcularTiempoMaximo(montoCargado, LocalTime.now());
			e.setHoraDeFinalizacion(horaMaximaDeFin);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());   
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

	public INotificacion consultarSaldo(int nroCelular) {	
		return new NotificacionAlertaConsultaDeSaldo(celular.consultarSaldo(nroCelular), nroCelular);
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

	@Override
	public GestorSem getGestorSem() {
		return this;
	}

	@Override
	public void suscribir(IObserver ob) {
		this.subscriptores.add(ob);
		
	}

	@Override
	public void desuscribir(IObserver ob) {
		this.subscriptores.remove(ob);
		
	}

	@Override
	public void notificarInicioEstacionamiento(INotificacion notificacionInicio) {
		this.subscriptores.stream().forEach(ob -> ob.recibirAlertaFinEstacionamiento(notificacionInicio));;
	}

	@Override
	public void notificarFinalizacioNEstacionamiento(INotificacion notificacionFin) {

		this.subscriptores.stream().forEach(ob -> ob.recibirAlertaFinEstacionamiento(notificacionFin));;
		
	}

}

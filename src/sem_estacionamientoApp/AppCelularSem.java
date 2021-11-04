package sem_estacionamientoApp;

import sem.GestorSem;
import sem_notificacion.INotificacion;

public class AppCelularSem implements MovementSensor {

	private int nroCelular;
	private String nroPatente;
	private int coordenadaGPS;
	private GestorSem gestor;
	private EstadoApp estadoMovimiento;
	private ModoApp modo;
	
	public AppCelularSem(int nroCelular, String nroPatente, GestorSem gestor, EstadoApp estado, ModoApp modo) {
		super();
		this.nroCelular = nroCelular;
		this.nroPatente = nroPatente;
		this.gestor = gestor;
		this.estadoMovimiento = estado;
		this.modo = modo;
	}
	/**
	 * Metodos que inician el estacionamiento y finaliza el estcionamiento
	 * de forma manual 
	 * */
	
	public INotificacion iniciarEstacionamiento(String nroPatente, int nroCelular, int puntoGeografico) {
		return gestor.iniciarEstacionamiento(nroPatente, nroCelular, puntoGeografico);
	}
	
	public INotificacion finalizarEstacionamiento(int nroCelular)  {
		return gestor.finalizarEstacionamiento(nroCelular);
	}
	
	public void informar(String msg)  {
		System.out.println(msg);
	}
	
	/**
	 * Metodos que inician el estacionamiento y finaliza el estacionamiento
	 * con la deteccion de movimiento ( Modo manual, Modo Automático )
	 * */
	
	public void comenzoACaminar(){	
		if(!gestor.tieneEstacionamientoVigente(this.getNroPatente()) && this.coordenadaGPSDentroDeUnaZona()) {
			this.getModo().iniciarEstacionamiento(this);
		}
		
	}
	
	public void comenzoAManejar(){
		if(gestor.tieneEstacionamientoVigente(this.getNroPatente()) && this.estaEnElMismoPuntoGeograficoDeInicioEstacionamiento()) {
			this.getModo().finalizarEstacionamiento(this);
		}
	}

	public Boolean estaEnElMismoPuntoGeograficoDeInicioEstacionamiento() {
		return gestor.estaEnElMismoPuntoGeograficoDeInicioEstaciomiento(this.getCoordenadaGPS(), this.getNroPatente());
	}

	public Boolean coordenadaGPSDentroDeUnaZona() {
		return gestor.estaDentroDeUnaZonaConLaCoordenada(this.getCoordenadaGPS());
	}
	
	public INotificacion consultarSaldo() {	
		return gestor.consultarSaldo(this.getNroCelular());
	}
	
	@Override
	public void driving() {
		this.getEstadoMovimiento().manejando(this);
		
	}

	@Override
	public void walking() {
		this.getEstadoMovimiento().caminando(this);
		
	}
	
	/**
	 * Getters and Setters
	 */
	
	public int getNroCelular() {
		return nroCelular;
	}

	public void setNroCelular(int nroCelular) {
		this.nroCelular = nroCelular;
	}

	public String getNroPatente() {
		return nroPatente;
	}

	public void setNroPatente(String nroPatente) {
		this.nroPatente = nroPatente;
	}

	public EstadoApp getEstadoMovimiento() {
		return estadoMovimiento;
	}

	public void setEstadoMovimiento(EstadoApp estado) {
		this.estadoMovimiento = estado;
	}

	public ModoApp getModo() {
		return modo;
	}
	

	public void setModo(ModoApp modo) {
		this.modo = modo;
	}

	public int getCoordenadaGPS() {
		return coordenadaGPS;
	}
	
	public void setCoordenadaGPS(int coordenada) {
		this.coordenadaGPS = coordenada;
	}

	public GestorSem getGestor() {
		return gestor;
	}


}


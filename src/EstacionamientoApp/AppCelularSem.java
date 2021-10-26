package EstacionamientoApp;

import Sem_Estacionamiento.GestorSem;

public class AppCelularSem implements MovementSensor {

	private int nroCelular;
	private String nroPatente;
	private double saldoDisponible;
	private int coordenadaGPS;
	private GestorSem gestor;
	private EstadoApp estado;
	private ModoApp modo;
	
	public AppCelularSem(int nroCelular, String nroPatente, GestorSem gestor, EstadoApp estado, ModoApp modo) {
		super();
		this.nroCelular = nroCelular;
		this.nroPatente = nroPatente;
		this.gestor = gestor;
		this.estado = estado;
		this.modo = modo;
	}
	
	/**
	 * Metodos que inician el estacionamiento y finaliza el estacionamiento
	 * con la deteccion de movimiento 
	 * */
	
	public void comenzoACaminar(){
		
		if(!gestor.tieneEstacionamientoVigente() && this.coordenadaGPSDentroDeUnaZona()) {
			this.getModo().alertaInicioDeEstacionamiento();
		}
		
	}
	
	public void comenzoAManejar(){
		if(gestor.tieneEstacionamientoVigente() && this.estaEnElMismoPuntoGeograficoDeInicioEstcaiomiento()) {
			this.getModo().alertaDeFinDeEstacionamiento();
		}
	}
	
	public Boolean estaEnElMismoPuntoGeograficoDeInicioEstcaiomiento() {
		return gestor.estaEnElMismoPuntoGeograficoDeInicioEstcaiomiento(this.getCoordenadaGPS());
	}

	public Boolean coordenadaGPSDentroDeUnaZona() {
		return gestor.estaDentroDeUnaZonaConLaCoordenada(this.getCoordenadaGPS());
	}

	@Override
	public void driving() {
		this.getEstado().comenzoAConducir(this);
		
	}

	@Override
	public void walking() {
		this.getEstado().comenzoACaminar(this);
		
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

	public double getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(double saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}

	public EstadoApp getEstado() {
		return estado;
	}

	public void setEstado(EstadoApp estado) {
		this.estado = estado;
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

	public GestorSem getGestor() {
		return gestor;
	}


}


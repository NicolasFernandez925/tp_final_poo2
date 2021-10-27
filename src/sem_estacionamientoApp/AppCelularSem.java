package sem_estacionamientoApp;

import sem.GestorSem;

public class AppCelularSem implements MovementSensor {

	private int nroCelular;
	private String nroPatente;
	private double saldoDisponible;
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
	
	public String iniciarEstacionamiento(String nroPatente) {
		return modo.iniciarEstacionamiento(nroPatente, this.getGestor(), this);
	}
	
	public String finalizarEstacionamiento() {
		return modo.finalizarEstacionamiento(this.getGestor());
	}
	
	/**
	 * Metodos que inician el estacionamiento y finaliza el estacionamiento
	 * con la deteccion de movimiento 
	 * */
	
	public void comenzoACaminar(){	
		if(!gestor.tieneEstacionamientoVigente() && this.coordenadaGPSDentroDeUnaZona()) {
			this.getModo().alertaInicioDeEstacionamiento(this.getGestor(), this);
		}
		
	}
	
	public void comenzoAManejar(){
		if(gestor.tieneEstacionamientoVigente() && this.estaEnElMismoPuntoGeograficoDeInicioEstacionamiento()) {
			this.getModo().alertaDeFinDeEstacionamiento(this.getGestor());
		}
	}
	
	public Boolean estaEnElMismoPuntoGeograficoDeInicioEstacionamiento() {
		return gestor.estaEnElMismoPuntoGeograficoDeInicioEstcaiomiento(this.getCoordenadaGPS());
	}

	public Boolean coordenadaGPSDentroDeUnaZona() {
		return gestor.estaDentroDeUnaZonaConLaCoordenada(this.getCoordenadaGPS());
	}
	
	public double consultarSaldo() {
		return this.getSaldoDisponible();
	}
	
	public Boolean seEncuentraEnZonaElUsuario(int coordenada) {
		return gestor.seEncuentraEnZonaElUsuario(coordenada);
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

	public double getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(double saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
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


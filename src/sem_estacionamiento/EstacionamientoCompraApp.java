package sem_estacionamiento;
import java.time.LocalTime;

public class EstacionamientoCompraApp extends Estacionamiento {

	private Boolean estaVigente;
	private int numeroDeCelular;

	public EstacionamientoCompraApp(String patente, LocalTime horaFinal, int puntoGeografico, int numeroDeCelular) {
		super(patente, horaFinal, puntoGeografico);
		this.numeroDeCelular = numeroDeCelular;
		this.estaVigente = true;
	}
	
	@Override
	public Boolean estacionamientoVigente() {
		return this.estaVigente;
		
	}

	@Override
	public void finalizar(LocalTime horaFin) {
		this.setEstaVigente(false);
		this.setHoraDeFinalizacion(horaFin);
		
	}
	
	public Boolean sonNumerosIguales(int nroCelular) {
		return nroCelular == this.getNumeroDeCelular();
	}
	
	public Boolean getEstaVigente() {
		return this.estaVigente;
	}
	
	public void setEstaVigente(Boolean estaVigente) {
		this.estaVigente = estaVigente;
	}

	public int getNumeroDeCelular() {
		return numeroDeCelular;
	}

	public void setNumeroDeCelular(int numeroDeCelular) {
		this.numeroDeCelular = numeroDeCelular;
	}

	public void establecerHoraFinEstacionamiento(LocalTime horaFin) {
		this.setHoraDeFinalizacion(horaFin);
	}
	
}

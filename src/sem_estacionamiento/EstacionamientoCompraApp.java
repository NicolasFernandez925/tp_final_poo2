package sem_estacionamiento;
import java.time.LocalTime;

public class EstacionamientoCompraApp extends Estacionamiento {

	private Boolean estaVigente;
	private int numeroDeCelular;

	public EstacionamientoCompraApp(String patente,int puntoGeografico, int numeroDeCelular, LocalTime horaFinal) {
		super(patente, horaFinal, puntoGeografico);
		this.numeroDeCelular = numeroDeCelular;
		this.estaVigente = true;
	}
	
	@Override
	public Boolean estacionamientoVigente() {
		return this.estaVigente;
		
	}

	public Boolean sonNumerosIguales(int nroCelular) {
		return nroCelular == this.getNumeroDeCelular();
	}

	@Override
	public void finalizar(LocalTime horaFin) {
		this.setEstaVigente(false);
		this.setHoraDeFinalizacion(horaFin);
		
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
//	// Este metodo se anulario ya que desde el gestor se calcula y luego se utiliza el set para actualizar el nuevo
//	// horario de fin
//	public void actualizarHorario(int minutos) {
//		LocalTime nuevoHorarioFinalizacion = this.getHoraDeFinalizacion().plusMinutes(minutos);
//		this.setHoraDeFinalizacion(nuevoHorarioFinalizacion);
//	}
//	
	public void establecerHoraFinEstacionamiento(LocalTime horaFin) {
		this.setHoraDeFinalizacion(horaFin);
	}
	
	public void costo() {
		//TODO
	}
	
	public LocalTime getHoraMaxima() {
		//Testear si funca ok l,a hora
		LocalTime horaMaxima =  LocalTime.of(20, 0);
		return this.tieneSaldo() ?  horaMaxima : this.horasQueAlcanzan();
	}

	public boolean tieneSaldo() {
		// TODO Auto-generated method stub
		return false;
	}

	public LocalTime horasQueAlcanzan() {
		// TODO Auto-generated method stub
		return null;
	}
}

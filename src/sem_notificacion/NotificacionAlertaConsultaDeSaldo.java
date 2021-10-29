package sem_notificacion;

public class NotificacionAlertaConsultaDeSaldo implements INotificacion {
	
	private double saldoDisponible;
	private int nroCelular;

	public NotificacionAlertaConsultaDeSaldo(double saldoDisponible, int nroCelular) {
		super();
		this.saldoDisponible = saldoDisponible;
		this.nroCelular = nroCelular;
	}

	@Override
	public String mensaje() {
		return "El saldo actual del Nro.: " + nroCelular + " es de: " + saldoDisponible;
	}

}

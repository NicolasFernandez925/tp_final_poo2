package sem_notificacion;

public class NotificacionAlertaInicioDeEstacionamiento implements INotificacion {

	private String msg;
	
	public NotificacionAlertaInicioDeEstacionamiento(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String mensaje() {
		return this.msg;
	}

}

package sem_notificacion;

public class NotificacionAlertaDeEstacionamiento implements INotificacion {

	private String msg;
	
	public NotificacionAlertaDeEstacionamiento(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String mensaje() {
		return this.msg;
	}

}

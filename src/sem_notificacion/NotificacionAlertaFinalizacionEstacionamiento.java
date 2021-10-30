package sem_notificacion;

public class NotificacionAlertaFinalizacionEstacionamiento implements INotificacion {

	private String msg;
	
	public NotificacionAlertaFinalizacionEstacionamiento(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String mensaje() {
		return this.msg;
	}
}

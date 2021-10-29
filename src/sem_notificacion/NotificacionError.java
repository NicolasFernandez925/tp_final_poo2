package sem_notificacion;

public class NotificacionError implements INotificacion {
	
	private String msgError;
	
	public NotificacionError(String error) {
		this.msgError = error;
	}
	
	public String mensaje() {
		return this.msgError;
	}
}

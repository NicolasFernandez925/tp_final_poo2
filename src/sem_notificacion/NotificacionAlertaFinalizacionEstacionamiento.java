package sem_notificacion;

public class NotificacionAlertaFinalizacionEstacionamiento implements INotificacion {

	@Override
	public String mensaje() {	
		return "Alerta, recuerde finalizar el estacionamiento";
	}
}

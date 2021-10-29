package sem_notificacion;

public class NotificacionAlertaInicioDeEstacionamiento implements INotificacion {

	@Override
	public String mensaje() {
		return "Alerta, recuerde iniciar el estacionamiento";
	}

}

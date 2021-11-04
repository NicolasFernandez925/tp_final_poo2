package sem_estacionamientoApp;

import sem_notificacion.INotificacion;
import sem_notificacion.NotificacionAlertaDeEstacionamiento;

public class ModoManual implements ModoApp {

	@Override
	public INotificacion iniciarEstacionamiento(AppCelularSem app) {
		return new NotificacionAlertaDeEstacionamiento("Alerta, recuerde iniciar el estacionamiento");
	}

	@Override
	public INotificacion finalizarEstacionamiento(AppCelularSem app) {
		return new NotificacionAlertaDeEstacionamiento("Alerta, recuerde finalizar el estacionamiento");
	}
	
}

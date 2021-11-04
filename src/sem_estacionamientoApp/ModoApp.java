package sem_estacionamientoApp;

import sem_notificacion.INotificacion;

public interface ModoApp {

	public INotificacion iniciarEstacionamiento(AppCelularSem app);
	public INotificacion finalizarEstacionamiento(AppCelularSem app);
	
}

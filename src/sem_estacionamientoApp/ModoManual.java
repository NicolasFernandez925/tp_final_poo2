package sem_estacionamientoApp;

import sem.GestorSem;
import sem_notificacion.INotificacion;
import sem_notificacion.NotificacionAlertaFinalizacionEstacionamiento;
import sem_notificacion.NotificacionAlertaInicioDeEstacionamiento;

public class ModoManual implements ModoApp {

	@Override
	public INotificacion alertaInicioDeEstacionamiento(GestorSem gestor, AppCelularSem app, int nroCelular) {
		return new NotificacionAlertaInicioDeEstacionamiento("Alerta, recuerde iniciar el estacionamiento");
	}

	@Override
	public INotificacion alertaDeFinDeEstacionamiento(GestorSem gestor, int nroCelular) {
		return new NotificacionAlertaFinalizacionEstacionamiento("Alerta, recuerde finalizar el estacionamiento");
	}
	
	@Override
	public INotificacion iniciarEstacionamiento(String patente,GestorSem gestor, AppCelularSem app, int nroCelular) {
		return gestor.iniciarEstacionamiento(app.getNroPatente(),nroCelular);
		
	}

	@Override
	public INotificacion finalizarEstacionamiento(GestorSem gestor, int nroCelular)  {
		return gestor.finalizarEstacionamiento(nroCelular);
	}

}

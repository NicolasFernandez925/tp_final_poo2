package sem_estacionamientoApp;

import sem.GestorSem;
import sem_notificacion.INotificacion;
import sem_notificacion.NotificacionError;

public class ModoAutomatico implements ModoApp {

	@Override
	public INotificacion alertaInicioDeEstacionamiento(GestorSem gestor, AppCelularSem app,  int nroCelular) {
		 return gestor.iniciarEstacionamiento(app.getNroPatente(), nroCelular);
	}

	@Override
	public INotificacion alertaDeFinDeEstacionamiento(GestorSem gestor, int nroCelular) {
		 return gestor.finalizarEstacionamiento(nroCelular);
	}

	@Override
	public INotificacion iniciarEstacionamiento(String patente, GestorSem gestor, AppCelularSem app, int nroCelular) {
		return new NotificacionError("No se puede iniciar estacionamiento de forma manual en automatico! por favor, cambiar a Modo manual");
	}

	@Override
	public INotificacion finalizarEstacionamiento(GestorSem gestor, int nroCelular) {
		return new NotificacionError("No se puede finalizar estacionamiento de forma manual en automatico! por favor, cambiar a Modo manual");
	}
}

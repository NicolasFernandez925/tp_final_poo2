package sem_estacionamientoApp;

import sem_notificacion.INotificacion;

public class ModoAutomatico implements ModoApp {

	@Override
	public INotificacion iniciarEstacionamiento(AppCelularSem app) {
		// Aca deberia ir el msg de que se detecto el inicio de forma automatica
		app.informar("se inicio de forma automatica el inicio del estacionamiento");
		return app.iniciarEstacionamiento(app.getNroPatente(), app.getNroCelular(), app.getCoordenadaGPS());
	}

	@Override
	public INotificacion finalizarEstacionamiento(AppCelularSem app) {
		// Aca deberia ir el msg de que se detecto la finalizacion de forma automatica
		app.informar("se finalizo de forma automatica el inicio del estacionamiento");
		return app.finalizarEstacionamiento(app.getNroCelular());
	}
	
}

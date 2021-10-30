package sem_estacionamientoApp;

import sem.GestorSem;
import sem_notificacion.INotificacion;

public class ModoAutomatico implements ModoApp {

	@Override
	public INotificacion alertaInicioDeEstacionamiento(GestorSem gestor, AppCelularSem app,  int nroCelular) {
		// TODO Auto-generated method stub
		 return gestor.iniciarEstacionamiento(app.getNroPatente(), nroCelular);
	}

	@Override
	public INotificacion alertaDeFinDeEstacionamiento(GestorSem gestor, int nroCelular) {
		// TODO Auto-generated method stub
		 return gestor.finalizarEstacionamiento(nroCelular);
	}

	@Override
	public String iniciarEstacionamiento(String patente, GestorSem gestor, AppCelularSem app, int nroCelular) {
		// TODO Auto-generated method stub
		return "No se puede iniciar estacionamiento de forma manual en automatico! por favor, cambiar a Modo manual";
	}

	@Override
	public String finalizarEstacionamiento(GestorSem gestor, int nroCelular) {
		// TODO Auto-generated method stub
		return "No se puede finalizar estacionamiento de forma manual en automatico! por favor, cambiar a Modo manual";
	}
}

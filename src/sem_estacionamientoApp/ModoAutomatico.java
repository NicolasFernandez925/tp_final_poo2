package sem_estacionamientoApp;

import sem.GestorSem;

public class ModoAutomatico implements ModoApp {

	@Override
	public String alertaInicioDeEstacionamiento(GestorSem gestor, AppCelularSem app,  int nroCelular) {
		// TODO Auto-generated method stub
		 return gestor.iniciarEstacionamiento(app.getNroPatente(), nroCelular);
	}

	@Override
	public String alertaDeFinDeEstacionamiento(GestorSem gestor, int nroCelular) {
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

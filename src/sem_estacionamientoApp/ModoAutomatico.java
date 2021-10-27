package sem_estacionamientoApp;

import sem.GestorSem;

public class ModoAutomatico implements ModoApp {

	@Override
	public String alertaInicioDeEstacionamiento(GestorSem gestor, AppCelularSem app, double saldoDisponible,  int nroCelular) {
		// TODO Auto-generated method stub
		 return gestor.iniciarEstacionamiento(app.getNroPatente(), saldoDisponible, nroCelular);
	}

	@Override
	public String alertaDeFinDeEstacionamiento(GestorSem gestor) {
		// TODO Auto-generated method stub
		 return gestor.finalizarEstacionamiento();
	}

	@Override
	public String iniciarEstacionamiento(String patente, GestorSem gestor, AppCelularSem app,double saldoDisponible, int nroCelular) {
		// TODO Auto-generated method stub
		return "No se puede iniciar estacionamiento de forma manual en automatico! por favor, cambiar a Modo manual";
	}

	@Override
	public String finalizarEstacionamiento(GestorSem gestor) {
		// TODO Auto-generated method stub
		return "No se puede finalizar estacionamiento de forma manual en automatico! por favor, cambiar a Modo manual";
	}

}

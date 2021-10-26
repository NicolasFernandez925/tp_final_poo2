package EstacionamientoApp;

import Sem_Estacionamiento.GestorSem;

public class ModoManual implements ModoApp {

	@Override
	public String alertaInicioDeEstacionamiento(GestorSem gestor, AppCelularSem app) {
		// TODO Auto-generated method stub
		return "Alerta, recuerde iniciar el estacionamiento";
	}

	@Override
	public String alertaDeFinDeEstacionamiento(GestorSem gestor) {
		// TODO Auto-generated method stub
		return "Alerta, recuerde finalizar el estacionamiento";
	}

	@Override
	public String iniciarEstacionamiento(String patente,GestorSem gestor, AppCelularSem app) {
		return gestor.iniciarEstacionamiento(app.getNroPatente());
		
	}

	@Override
	public String finalizarEstacionamiento(GestorSem gestor) {
		// TODO Auto-generated method stub
		return gestor.finalizarEstacionamiento();
	}

}

package sem_estacionamientoApp;

import sem.GestorSem;

public class ModoManual implements ModoApp {

	@Override
	public String alertaInicioDeEstacionamiento(GestorSem gestor, AppCelularSem app, int nroCelular) {
		// TODO Auto-generated method stub
		return "Alerta, recuerde iniciar el estacionamiento";
	}

	@Override
	public String alertaDeFinDeEstacionamiento(GestorSem gestor, int nroCelular) {
		// TODO Auto-generated method stub
		return "Alerta, recuerde finalizar el estacionamiento";
	}
	
	@Override
	public String iniciarEstacionamiento(String patente,GestorSem gestor, AppCelularSem app, int nroCelular) {
		return gestor.iniciarEstacionamiento(app.getNroPatente(),nroCelular);
		
	}

	@Override
	public String finalizarEstacionamiento(GestorSem gestor, int nroCelular)  {
		// TODO Auto-generated method stub
		return gestor.finalizarEstacionamiento(nroCelular);
	}

}

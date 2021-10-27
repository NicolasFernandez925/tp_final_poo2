package sem_estacionamientoApp;

import sem.GestorSem;

public class ModoManual implements ModoApp {

	@Override
	public String alertaInicioDeEstacionamiento(GestorSem gestor, AppCelularSem app, double saldoDisponible, int nroCelular) {
		// TODO Auto-generated method stub
		return "Alerta, recuerde iniciar el estacionamiento";
	}

	@Override
	public String alertaDeFinDeEstacionamiento(GestorSem gestor) {
		// TODO Auto-generated method stub
		return "Alerta, recuerde finalizar el estacionamiento";
	}

	@Override
	public String iniciarEstacionamiento(String patente,GestorSem gestor, AppCelularSem app, double saldoDisponible, int nroCelular) {
		return gestor.iniciarEstacionamiento(app.getNroPatente(), saldoDisponible, nroCelular);
		
	}

	@Override
	public String finalizarEstacionamiento(GestorSem gestor) {
		// TODO Auto-generated method stub
		return gestor.finalizarEstacionamiento();
	}

}

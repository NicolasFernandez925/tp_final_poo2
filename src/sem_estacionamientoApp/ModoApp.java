package sem_estacionamientoApp;

import sem.GestorSem;

public interface ModoApp {

	public String alertaInicioDeEstacionamiento(GestorSem gestor, AppCelularSem app, double saldoDisponible, int nroCelular);
	public String alertaDeFinDeEstacionamiento(GestorSem gestor);
	public String iniciarEstacionamiento(String patente, GestorSem gestor, AppCelularSem app, double saldoDisponible, int nroCelular);
	public String finalizarEstacionamiento(GestorSem gestor);
}

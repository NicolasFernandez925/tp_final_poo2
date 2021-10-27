package sem_estacionamientoApp;

import sem.GestorSem;

public interface ModoApp {

	public String alertaInicioDeEstacionamiento(GestorSem gestor, AppCelularSem app);
	public String alertaDeFinDeEstacionamiento(GestorSem gestor);
	public String iniciarEstacionamiento(String patente, GestorSem gestor, AppCelularSem app);
	public String finalizarEstacionamiento(GestorSem gestor);
}
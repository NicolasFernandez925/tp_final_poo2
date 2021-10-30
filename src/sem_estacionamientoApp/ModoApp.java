package sem_estacionamientoApp;

import sem.GestorSem;
import sem_notificacion.INotificacion;

public interface ModoApp {

	public INotificacion alertaInicioDeEstacionamiento(GestorSem gestor, AppCelularSem app,int nroCelular);
	public INotificacion alertaDeFinDeEstacionamiento(GestorSem gestor, int nroCelular) ;
	public INotificacion iniciarEstacionamiento(String patente, GestorSem gestor, AppCelularSem app, int nroCelular);
	public INotificacion finalizarEstacionamiento(GestorSem gestor, int nroCelular) ;
}

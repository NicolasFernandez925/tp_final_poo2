package sem_estacionamientoApp;


public class EnVehiculo implements EstadoApp {

	@Override
	public void manejando(AppCelularSem app) {}

	@Override
	public void caminando(AppCelularSem app) {
		app.setEstadoMovimiento(new APie());
		app.comenzoACaminar();
		
	}

}

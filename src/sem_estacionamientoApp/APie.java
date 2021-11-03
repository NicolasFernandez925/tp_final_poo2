package sem_estacionamientoApp;

public class APie implements EstadoApp {

	@Override
	public void manejando(AppCelularSem app) {
		app.setEstadoMovimiento(new EnVehiculo());
		app.comenzoAManejar();
		
	}

	@Override
	public void caminando(AppCelularSem app) {}

}

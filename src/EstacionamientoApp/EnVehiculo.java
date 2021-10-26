package EstacionamientoApp;

public class EnVehiculo implements EstadoApp {

	@Override
	public void manejando(AppCelularSem app) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caminando(AppCelularSem app) {
		app.setEstadoMovimiento(new APie());
		app.comenzoACaminar();
		
	}

}

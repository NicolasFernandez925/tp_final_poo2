package sem_Inspector;

import sem.ISemEstacionamiento;
import sem_multa.Multa;

public class AppInspector implements ISemInspector {

	private int id;

	private ISemEstacionamiento semEstacionamiento;
	
	public AppInspector(ISemEstacionamiento semEstacionamiento) {
		this.semEstacionamiento = semEstacionamiento;
		this.id = 15;
	}
	
	@Override
	public void registrarMulta(Multa multa) {
		// TODO Falta implementar
		
	}
	
	public void consultarEstacionamientoVigente(String nroPatente) {
		semEstacionamiento.consultarEstacionamiento(nroPatente, this.getId());
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}

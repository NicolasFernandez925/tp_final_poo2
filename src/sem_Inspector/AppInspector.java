package sem_Inspector;

import sem.ISemEstacionamiento;
import sem_Zona.Zona;
import sem_multa.Multa;

public class AppInspector {

	private int id;
	private ISemMulta semMulta;
	private ISemEstacionamiento semEstacionamiento;
	
	public AppInspector(ISemEstacionamiento semEstacionamiento, ISemMulta semMulta) {
		this.semEstacionamiento = semEstacionamiento;
		this.semMulta = semMulta;
		this.id = 15;
	}
	
	public void registrarMulta(String patente,Zona zona) {
		if(!this.consultarEstacionamientoVigente(patente)) {
			semMulta.registrarMulta(new Multa(patente, zona, this.getId()));	
		}
		
	}
	
	public boolean consultarEstacionamientoVigente(String nroPatente) {
		return semEstacionamiento.consultarEstacionamiento(nroPatente, this.getId());
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}

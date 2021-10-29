package sem_multa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SemMulta implements ISemMulta {

	private List<Multa> multas;
	
	public SemMulta() {
		this.multas = new ArrayList<Multa>();
	}
	
	public void registrarMulta(Multa multa) {
		this.getMultas().add(multa);
	}
	
	public int cantidadDeMultas() {
		return this.getMultas().size();
	}

	public List<Multa> getMultas() {
		return multas;
	}
	
	public List<Multa> getMultasConPatente(String patente) {
		return this.getMultas().stream().filter(m -> m.getPatente() == patente).collect(Collectors.toList());
	}
}

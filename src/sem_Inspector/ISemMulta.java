package sem_Inspector;

import java.util.List;

import sem_multa.Multa;

public interface ISemMulta {
	public void registrarMulta(Multa multa);
	public List<Multa> getMultasConPatente(String patente);
}

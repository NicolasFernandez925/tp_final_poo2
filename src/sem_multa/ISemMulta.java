package sem_multa;

import java.util.List;

public interface ISemMulta {
	public void registrarMulta(Multa multa);
	public List<Multa> getMultasConPatente(String patente);
}

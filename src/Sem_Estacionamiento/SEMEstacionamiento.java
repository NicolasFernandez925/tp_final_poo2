package system;
import java.util.ArrayList;


public class SEMEstacionamiento {
	ArrayList<Zona> zonas;
	
	public SEMEstacionamiento(){
		this.zonas = new ArrayList();
	};
	
	public void agregarZona(Zona _zona) {
		this.zonas.add(_zona);
	}
	
	public boolean consultarEstacionamiento(int nroDePatente) {
		return this.zonas.stream().anyMatch(zona -> zona.tieneEstacionamiento(nroDePatente));
	}
	
	public int cantidadDeEstacionamientos() {
		return  this.zonas.stream().map(Zona :: cantidadDeEstacionamientos).reduce(0, (subtotal, valor) -> subtotal + valor);
	}
	
	public int cantidadDeZonas() {
		return (int) this.zonas.stream().count();
	}
	
	public Zona getPuntoDeVentaEnLaZonaMasCercana(int coordenada) {
		return null;
	}
	
	
	
}
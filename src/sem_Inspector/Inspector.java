package sem_Inspector;

public class Inspector {

	private String nombre;
	private int id;
	private int dni;
	
	public Inspector(int id, String nombre, int dni) {
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}

	public int getId() {
		return id;
	}

	public int getDni() {
		return dni;
	}
}

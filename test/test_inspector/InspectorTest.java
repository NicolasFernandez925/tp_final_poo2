package test_inspector;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_Inspector.Inspector;

class InspectorTest {
	
	Inspector inspector;
	int id;
	String nombre;
	int dni;

	@BeforeEach
	void setUp() throws Exception {
		
		inspector = new Inspector(id, nombre, dni);
	}

	@Test
	void testGetNombre() {
		assertEquals(nombre, inspector.getNombre());
	}
	
	@Test
	void testGetId() {
		assertEquals(id, inspector.getId());
	}
	
	@Test
	void testGetDni() {
		assertEquals(dni, inspector.getDni());
	}

}

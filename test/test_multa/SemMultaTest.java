package test_multa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_multa.Multa;
import sem_multa.SemMulta;

class SemMultaTest {
	
	SemMulta sutSemMulta;
	Multa multaMock1;
	Multa multaMock2;
	Multa multaMock3;
	String patente;
	List<Multa> multas;

	@BeforeEach
	void setUp() throws Exception {
		
		patente = "NOD281";
		
		multaMock1 = mock(Multa.class);
		multaMock2 = mock(Multa.class);
		multaMock3 = mock(Multa.class);
		
		sutSemMulta = new SemMulta();
		
		sutSemMulta.registrarMulta(multaMock1);
		sutSemMulta.registrarMulta(multaMock2);
		
		multas = Arrays.asList(multaMock1,multaMock2);
	}

	@Test
	void testGetMultas() {
		assertEquals(multas, sutSemMulta.getMultas());
	}
	
	@Test
	void testRegistrarMulta() {
		sutSemMulta.registrarMulta(multaMock3);
		assertTrue(sutSemMulta.getMultas().contains(multaMock3));
	}
	
	@Test
	void testCantidadDeMultas() {
		assertEquals(2,sutSemMulta.cantidadDeMultas());
	}
	
	
	@Test
	void testGetMultasDeUnaPatenteEspecifica() {
		
		List<Multa> listEsperada = Arrays.asList(multaMock1);
		
		when(multaMock1.getPatente()).thenReturn("NOD281");
		when(multaMock2.getPatente()).thenReturn("SRA812");
		when(multaMock3.getPatente()).thenReturn("VOY092");
		
		assertEquals(sutSemMulta.getMultasConPatente(patente), listEsperada);
	}

}

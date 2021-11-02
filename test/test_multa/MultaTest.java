package test_multa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_Zona.Zona;
import sem_multa.Multa;

class MultaTest {
	
	Multa sutMulta;
	Zona zonaMock;
	String patente;
	int idInspector;

	@BeforeEach
	void setUp() throws Exception {
		
		patente = "NOD292";
		idInspector = 1;
		zonaMock = mock(Zona.class);
		sutMulta = new Multa(patente,zonaMock, idInspector);
		
	}

	@Test
	void testGetPatente() {
		assertEquals(patente, sutMulta.getPatente());	
	}
	
	@Test
	void testGetIdInspector() {		
		assertEquals(idInspector, sutMulta.getIdInspector());
	}
	
	@Test
	void testGetZona() {
		assertEquals(zonaMock, sutMulta.getZona());
	}
	
	@Test
	void testGetHora() {
		assertEquals(LocalTime.now().withNano(0), sutMulta.getHora().withNano(0));
	}
	
	@Test
	void testGetFecha() {
		assertEquals(LocalDate.now(), sutMulta.getFecha());
	}



}

package test_sem;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem.SEMEstacionamiento;
import sem_Zona.Zona;

class SEMEstacionamientoTest {
	
	List<Zona> zonas;
	String patente;
	Zona zona1;
	Zona zona2;
	SEMEstacionamiento sutEstacionamientoSem;

	@BeforeEach
	void setUp() throws Exception {
		zona1 = mock(Zona.class);
		zona2 = mock(Zona.class);
		patente = "YQT783";
		sutEstacionamientoSem = new SEMEstacionamiento();
		
		sutEstacionamientoSem.agregarZona(zona1);
		sutEstacionamientoSem.agregarZona(zona2);

	}

	@Test
	void testTieneEstacionamientoVigente() {
		when(zona1.tieneEstacionamientoVigente(patente)).thenReturn(true);
		when(zona2.tieneEstacionamientoVigente(patente)).thenReturn(true);
		assertTrue(sutEstacionamientoSem.tieneEstacionamientoVigente(patente));
	}

}

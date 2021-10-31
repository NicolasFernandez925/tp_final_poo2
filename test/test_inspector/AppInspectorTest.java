package test_inspector;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem.ISemEstacionamiento;
import sem_Inspector.AppInspector;
import sem_Zona.Zona;
import sem_multa.ISemMulta;
import sem_multa.Multa;

class AppInspectorTest {
	
	ISemMulta semMultaMock;
	Zona zonaMock;
	String patente;
	int idInspector;
	ISemEstacionamiento semEstacionamientoMock;
	AppInspector sutAppInspector;
	
	@BeforeEach
	void setUp() throws Exception {
		semMultaMock = mock(ISemMulta.class);
		semEstacionamientoMock = mock(ISemEstacionamiento.class);
		zonaMock = mock(Zona.class);
		patente = "IUQ273";
		idInspector = 1221;
		sutAppInspector = new AppInspector(semEstacionamientoMock,semMultaMock);
	}

	
	//Nose porque estos test no funancionan :/
	
	@Test
	void testRegistrarMultaConPatenteNoVigente() {		
		when(semEstacionamientoMock.consultarEstacionamiento(patente, idInspector)).thenReturn(false);
		sutAppInspector.registrarMulta(patente, zonaMock);		
		verify(semMultaMock).registrarMulta(any(Multa.class));
	}
	
	@Test
	void testRegistrarMultaConPatenteVigenteNoTerminaRegistrandola() {	
	
		when(semEstacionamientoMock.consultarEstacionamiento(patente, idInspector)).thenReturn(true);
		sutAppInspector.registrarMulta(patente, zonaMock);
		verify(semMultaMock, never()).registrarMulta(any(Multa.class));
	}


}

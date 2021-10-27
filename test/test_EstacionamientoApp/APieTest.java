package test_EstacionamientoApp;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_estacionamientoApp.APie;
import sem_estacionamientoApp.AppCelularSem;
import sem_estacionamientoApp.EstadoApp;

class APieTest {
	APie aPieSUT;
	AppCelularSem appCelularMock;

	@BeforeEach
	void setUp() throws Exception {
		
		aPieSUT = new APie();
		appCelularMock = mock(AppCelularSem.class);
		
	}

	@Test
	void testElGPSDetectaUnCambioDeAPieAManejando() {	
		aPieSUT.manejando(appCelularMock);
		verify(appCelularMock).setEstadoMovimiento(any(EstadoApp.class));
		verify(appCelularMock).comenzoAManejar();
	}
	
	@Test
	void testElGPSDetectaQueEstaAPieYNoHaceNada() {	
		aPieSUT.caminando(appCelularMock);
		verify(appCelularMock, never()).setEstadoMovimiento(any(EstadoApp.class));
		verify(appCelularMock, never()).comenzoAManejar();
	}

}
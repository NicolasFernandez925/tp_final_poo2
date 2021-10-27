package EstacionamientoApp;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
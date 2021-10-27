package EstacionamientoApp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnVehiculoTest {

	EnVehiculo enVehiculoSUT;
	AppCelularSem appCelularMock;

	@BeforeEach
	void setUp() throws Exception {
		
		enVehiculoSUT = new EnVehiculo();
		appCelularMock = mock(AppCelularSem.class);
		
	}

	@Test
	void testElGPSDetectaUnCambioDeManejandoAPie() {	
		enVehiculoSUT.caminando(appCelularMock);
		verify(appCelularMock).setEstadoMovimiento(any(EstadoApp.class));
		verify(appCelularMock).comenzoACaminar();
	}
	
	@Test
	void testElGPSDetectaQueEstaManejandoPeroNoHaceNada() {	
		enVehiculoSUT.manejando(appCelularMock);
		verify(appCelularMock, never()).setEstadoMovimiento(any(EstadoApp.class));
		verify(appCelularMock, never()).comenzoAManejar();
	}


}
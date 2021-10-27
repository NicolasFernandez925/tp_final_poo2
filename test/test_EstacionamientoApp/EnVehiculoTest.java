package test_EstacionamientoApp;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_estacionamientoApp.AppCelularSem;
import sem_estacionamientoApp.EnVehiculo;
import sem_estacionamientoApp.EstadoApp;

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

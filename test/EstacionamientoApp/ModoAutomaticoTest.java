package EstacionamientoApp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Sem_Estacionamiento.GestorSem;

class ModoAutomaticoTest {
	
	GestorSem gestorMock;
	AppCelularSem appMock;
	ModoAutomatico modoAutomaticoSut;
	String patente;

	@BeforeEach
	void setUp() throws Exception {
		patente = "VAS930";
		gestorMock = mock(GestorSem.class);
		appMock = mock(AppCelularSem.class);
		modoAutomaticoSut = new ModoAutomatico();
	}

	@Test
	void testElUsuarioEjecutaElModoAutomaticoEIniciaLaAlertaDeInicioDeEstacionamiento() {
		when(appMock.getNroPatente()).thenReturn(patente);
		modoAutomaticoSut.alertaInicioDeEstacionamiento(gestorMock,appMock);
		verify(gestorMock).iniciarEstacionamiento(patente);
	}
	
	@Test
	void testElUsuarioEjecutaElModoAutomaticoEIniciaLaAlertaDeFinalizacionEstacionamiento() {
		modoAutomaticoSut.alertaDeFinDeEstacionamiento(gestorMock);
		verify(gestorMock).finalizarEstacionamiento();
	}
	
	@Test
	void testElUsuarioEjecutaElIniciarEstacionamientoEstandoEnModoAutomatico() {
		String msgEsperado = "No se puede iniciar estacionamiento de forma manual en automatico! por favor, cambiar a Modo manual";	
		assertEquals(msgEsperado, modoAutomaticoSut.iniciarEstacionamiento(patente,gestorMock,appMock));
	}
	
	@Test
	void testElUsuarioEjecutaLaFinalizacionDelEstacionamientoEstandoEnModoAutomatico() {
		String msgEsperado = "No se puede finalizar estacionamiento de forma manual en automatico! por favor, cambiar a Modo manual";
		assertEquals(msgEsperado, modoAutomaticoSut.finalizarEstacionamiento(gestorMock));
	}

}

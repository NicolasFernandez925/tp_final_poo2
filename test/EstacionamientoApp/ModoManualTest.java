package EstacionamientoApp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Sem_Estacionamiento.GestorSem;

class ModoManualTest {

	GestorSem gestorMock;
	AppCelularSem appMock;
	ModoManual modoManualSut;
	String patente;

	@BeforeEach
	void setUp() throws Exception {
		patente = "VAS930";
		gestorMock = mock(GestorSem.class);
		appMock = mock(AppCelularSem.class);
		modoManualSut = new ModoManual();
	}

	@Test
	void testElUsuarioEjecutaElInicioDelEstacionamientoEnModoManualYValidaAlertaDeInicio() {
		String msgEsperado = "Alerta, recuerde iniciar el estacionamiento";
		assertEquals(msgEsperado, modoManualSut.alertaInicioDeEstacionamiento(gestorMock,appMock));
	}
	
	@Test
	void testElUsuarioEjecutaLaFinalizacionDelEstacionamientoEnModoManualYValidaAlertaDeFinalizacion() {
		String msgEsperado = "Alerta, recuerde finalizar el estacionamiento";
		assertEquals(msgEsperado, modoManualSut.alertaDeFinDeEstacionamiento(gestorMock));
	}
	
	@Test
	void testElUsuarioEjecutaEnModoManualElInicioDeEstacionamiento() {
		when(appMock.getNroPatente()).thenReturn(patente);
		modoManualSut.iniciarEstacionamiento(patente,gestorMock,appMock);
		verify(gestorMock).iniciarEstacionamiento(patente);
	}
	
	@Test
	void testElUsuarioEjecutaEnModoManualLaFinalizacionDelEstacionamiento() {
		modoManualSut.finalizarEstacionamiento(gestorMock);
		verify(gestorMock).finalizarEstacionamiento();
	}

}

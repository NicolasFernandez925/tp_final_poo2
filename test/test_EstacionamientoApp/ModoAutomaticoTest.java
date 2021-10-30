package test_EstacionamientoApp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem.GestorSem;
import sem_estacionamientoApp.AppCelularSem;
import sem_estacionamientoApp.ModoAutomatico;
import sem_notificacion.NotificacionError;


class ModoAutomaticoTest {
	
	GestorSem gestorMock;
	AppCelularSem appMock;
	ModoAutomatico modoAutomaticoSut;
	String patente;
	int nroCelular;

	@BeforeEach
	void setUp() throws Exception {
		patente = "VAS930";
		nroCelular = 1112233;
		gestorMock = mock(GestorSem.class);
		appMock = mock(AppCelularSem.class);
		modoAutomaticoSut = new ModoAutomatico();
	}

	@Test
	void testElUsuarioEjecutaElModoAutomaticoEIniciaLaAlertaDeInicioDeEstacionamiento() {
		when(appMock.getNroPatente()).thenReturn(patente);
		modoAutomaticoSut.alertaInicioDeEstacionamiento(gestorMock,appMock,nroCelular);
		verify(gestorMock).iniciarEstacionamiento(patente,nroCelular);
	}
	
	@Test
	void testElUsuarioEjecutaElModoAutomaticoEIniciaLaAlertaDeFinalizacionEstacionamiento() throws Exception {
		modoAutomaticoSut.alertaDeFinDeEstacionamiento(gestorMock,nroCelular);
		verify(gestorMock).finalizarEstacionamiento(nroCelular);	
	}
	
	@Test
	void testElUsuarioEjecutaElIniciarEstacionamientoEstandoEnModoAutomatico() {
		assertTrue(modoAutomaticoSut.iniciarEstacionamiento(patente,gestorMock,appMock,nroCelular) instanceof NotificacionError);
	}
	
	@Test
	void testElUsuarioEjecutaLaFinalizacionDelEstacionamientoEstandoEnModoAutomatico() {
		assertTrue(modoAutomaticoSut.iniciarEstacionamiento(patente,gestorMock,appMock,nroCelular) instanceof NotificacionError);
	}

}

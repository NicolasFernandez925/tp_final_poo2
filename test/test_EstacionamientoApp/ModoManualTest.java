package test_EstacionamientoApp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem.GestorSem;
import sem_estacionamientoApp.AppCelularSem;
import sem_estacionamientoApp.ModoManual;
import sem_notificacion.NotificacionAlertaDeEstacionamiento;


class ModoManualTest {

	GestorSem gestorMock;
	AppCelularSem appMock;
	ModoManual modoManualSut;
	String patente;
	int nroCelular;
	int coordenada;

	@BeforeEach
	void setUp() throws Exception {
		patente = "VAS930";
		nroCelular = 128281281;
		coordenada = 4;
		gestorMock = mock(GestorSem.class);
		appMock = mock(AppCelularSem.class);
		modoManualSut = new ModoManual();
	}
	
	@Test
	void testElUsuarioEjecutaElInicioDelEstacionamientoEnModoManualYValidaAlertaDeInicio() {
		assertTrue(modoManualSut.iniciarEstacionamiento(appMock) instanceof NotificacionAlertaDeEstacionamiento);
	}
	
	@Test
	void testElUsuarioEjecutaLaFinalizacionDelEstacionamientoEnModoManualYValidaAlertaDeFinalizacion() {
		assertTrue(modoManualSut.finalizarEstacionamiento(appMock) instanceof NotificacionAlertaDeEstacionamiento);
	}
	
}

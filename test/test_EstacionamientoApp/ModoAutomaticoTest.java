package test_EstacionamientoApp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem.GestorSem;
import sem_estacionamientoApp.AppCelularSem;
import sem_estacionamientoApp.ModoAutomatico;


class ModoAutomaticoTest {
	
	GestorSem gestorMock;
	AppCelularSem appMock;
	ModoAutomatico modoAutomaticoSut;
	String patente;
	//double saldoDisponible;
	int nroCelular;

	@BeforeEach
	void setUp() throws Exception {
		patente = "VAS930";
		nroCelular = 1112233;
		//saldoDisponible = 200.0;
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
		String msgEsperado = "No se puede iniciar estacionamiento de forma manual en automatico! por favor, cambiar a Modo manual";	
		assertEquals(msgEsperado, modoAutomaticoSut.iniciarEstacionamiento(patente,gestorMock,appMock,nroCelular));
	}
	
	@Test
	void testElUsuarioEjecutaLaFinalizacionDelEstacionamientoEstandoEnModoAutomatico() {
		String msgEsperado = "No se puede finalizar estacionamiento de forma manual en automatico! por favor, cambiar a Modo manual";
		assertEquals(msgEsperado, modoAutomaticoSut.finalizarEstacionamiento(gestorMock,nroCelular));
	}

}

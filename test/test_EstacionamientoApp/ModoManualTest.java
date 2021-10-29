package test_EstacionamientoApp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem.GestorSem;
import sem_estacionamientoApp.AppCelularSem;
import sem_estacionamientoApp.ModoManual;


class ModoManualTest {

	GestorSem gestorMock;
	AppCelularSem appMock;
	ModoManual modoManualSut;
	String patente;
	//double saldoDisponible;
	int nroCelular;

	@BeforeEach
	void setUp() throws Exception {
		patente = "VAS930";
		nroCelular = 128281281;
		//saldoDisponible = 200.0;
		gestorMock = mock(GestorSem.class);
		appMock = mock(AppCelularSem.class);
		modoManualSut = new ModoManual();
	}
	
	@Test
	void testElUsuarioEjecutaElInicioDelEstacionamientoEnModoManualYValidaAlertaDeInicio() {
		String msgEsperado = "Alerta, recuerde iniciar el estacionamiento";
		assertEquals(msgEsperado, modoManualSut.alertaInicioDeEstacionamiento(gestorMock,appMock,nroCelular));
	}
	
	@Test
	void testElUsuarioEjecutaLaFinalizacionDelEstacionamientoEnModoManualYValidaAlertaDeFinalizacion() {
		String msgEsperado = "Alerta, recuerde finalizar el estacionamiento";
		assertEquals(msgEsperado, modoManualSut.alertaDeFinDeEstacionamiento(gestorMock,nroCelular));
	}
	
	@Test
	void testElUsuarioEjecutaEnModoManualElInicioDeEstacionamiento() {
		when(appMock.getNroPatente()).thenReturn(patente);
		modoManualSut.iniciarEstacionamiento(patente,gestorMock,appMock,nroCelular);
		verify(gestorMock).iniciarEstacionamiento(patente,nroCelular);
	}
	
	@Test
	void testElUsuarioEjecutaEnModoManualLaFinalizacionDelEstacionamiento() throws Exception {
		modoManualSut.finalizarEstacionamiento(gestorMock,nroCelular);
		verify(gestorMock).finalizarEstacionamiento(nroCelular);
	}

}

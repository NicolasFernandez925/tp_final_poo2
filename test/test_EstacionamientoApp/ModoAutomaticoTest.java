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
	int nroCelular;
	int coordenada;
	
	@BeforeEach
	void setUp() throws Exception {
		patente = "VAS930";
		nroCelular = 1112233;
		coordenada = 4;
		gestorMock = mock(GestorSem.class);
		appMock = mock(AppCelularSem.class);
		modoAutomaticoSut = new ModoAutomatico();
	}

	@Test
	void testElUsuarioEjecutaElModoAutomaticoEIniciarEstacionamiento() {
		when(appMock.getNroPatente()).thenReturn(patente);
		when(appMock.getNroCelular()).thenReturn(nroCelular);
		when(appMock.getCoordenadaGPS()).thenReturn(coordenada);
		modoAutomaticoSut.iniciarEstacionamiento(appMock);
		verify(appMock).iniciarEstacionamiento(patente,nroCelular, coordenada);
	}
	
	@Test
	void testElUsuarioEjecutaElModoAutomaticoElFinalizarEstacionamiento() {
		when(appMock.getNroCelular()).thenReturn(nroCelular);		
		modoAutomaticoSut.finalizarEstacionamiento(appMock);
		verify(appMock).finalizarEstacionamiento(nroCelular);
	}
}

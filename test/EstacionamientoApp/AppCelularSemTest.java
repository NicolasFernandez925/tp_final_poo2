package EstacionamientoApp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Sem_Estacionamiento.GestorSem;

class AppCelularSemTest {
	
	AppCelularSem sutApp;
	GestorSem gestorMock;
	EstadoApp estadoAppMock;
	ModoApp modoAppMock;
	
	String patente;
	int nroCelular;
	int coordenadaGPS;

	@BeforeEach
	void setUp() throws Exception {
		patente = "VAS930";
		coordenadaGPS = 1822717272;
		nroCelular = 11267364;
		gestorMock = mock(GestorSem.class);
		modoAppMock = mock(ModoApp.class);
		estadoAppMock = mock(EstadoApp.class);
		
		sutApp = new AppCelularSem(nroCelular,patente,gestorMock, estadoAppMock, modoAppMock);
		sutApp.setCoordenadaGPS(coordenadaGPS);
	}
	
	@Test
	void testConstructor() {	
		assertTrue(sutApp.getNroPatente() == patente);
		assertTrue(sutApp.getNroCelular() == nroCelular);
		assertTrue(sutApp.getNroPatente() == patente);
		assertTrue(sutApp.getEstadoMovimiento() == estadoAppMock);
		assertTrue(sutApp.getModo() == modoAppMock);
		assertTrue(sutApp.getGestor() == gestorMock);
	}

	@Test
	void testAlRecibirMensajeDrivingEsteSeDelegaASusEstados() {
		
		sutApp.driving();	
		verify(estadoAppMock).manejando(sutApp);
	}
	
	@Test
	void testAlRecibirMensajeWalkingEsteSeDelegaASusEstados() {
		
		sutApp.walking();	
		verify(estadoAppMock).caminando(sutApp);
	}
	
	@Test
	void testDeIniciarEstacionamientoDeFormaManual() {	
		sutApp.iniciarEstacionamiento(patente);	
		verify(modoAppMock).iniciarEstacionamiento(patente, gestorMock, sutApp);
	}
	
	@Test
	void testDeFinalizarEstacionamientoDeFormaManual() {	
		sutApp.finalizarEstacionamiento();	
		verify(modoAppMock).finalizarEstacionamiento(gestorMock);
	}
	
	
	// TEST COMENZO A CAMINAR
	
	@Test 
	void testAlComenzarACaminarConEstacionamientoNoVigenteYDentroDeLaZonaConCoordenadaSeAlertaElInicioDelEstacionamiento() {
		
		when(gestorMock.tieneEstacionamientoVigente()).thenReturn(false);
		when(gestorMock.estaDentroDeUnaZonaConLaCoordenada(coordenadaGPS)).thenReturn(true);
		
		sutApp.comenzoACaminar();

		verify(modoAppMock).alertaInicioDeEstacionamiento(gestorMock, sutApp);
	}
	
	@Test 
	void testAlComenzarACaminarConEstacionamientoVigenteYDentroDeLaZonaConCoordenadaNoIniciaElEstacionamiento() {
		
		when(gestorMock.tieneEstacionamientoVigente()).thenReturn(true);
		when(gestorMock.estaDentroDeUnaZonaConLaCoordenada(coordenadaGPS)).thenReturn(true);
		
		sutApp.comenzoACaminar();

		verifyNoInteractions(modoAppMock);
	}
	
	@Test 
	void testAlComenzarACaminarConEstacionamientoVigenteYNOEstaDentroDeUnaZonaConCoordenadaNoIniciaElEstacionamiento() {
		
		when(gestorMock.tieneEstacionamientoVigente()).thenReturn(true);
		when(gestorMock.estaDentroDeUnaZonaConLaCoordenada(coordenadaGPS)).thenReturn(false);
		
		sutApp.comenzoACaminar();

		verifyNoInteractions(modoAppMock);
	}

	// TEST COMENZO A CONDUCIR
	
	@Test 
	void testAlComenzarAConducirConEstacionamientoNoVigenteYEstaEnElMismoPuntoGeograficoNoSeAlertaElInicioDelEstacionamiento() {
		
		when(gestorMock.tieneEstacionamientoVigente()).thenReturn(false);
		when(gestorMock.estaEnElMismoPuntoGeograficoDeInicioEstcaiomiento(coordenadaGPS)).thenReturn(true);
		
		sutApp.comenzoAManejar();
		verifyNoInteractions(modoAppMock);
		
	}
	
	@Test 
	void testAlComenzarAConducirConEstacionamientoVigenteYNOEstaEnElMismoPuntoGeograficoNoSeAlertaElInicioDelEstacionamiento() {
		
		when(gestorMock.tieneEstacionamientoVigente()).thenReturn(true);
		when(gestorMock.estaEnElMismoPuntoGeograficoDeInicioEstcaiomiento(coordenadaGPS)).thenReturn(false);
		
		sutApp.comenzoAManejar();

		verifyNoInteractions(modoAppMock);
	}
	
	@Test 
	void testAlComenzarAConducirConEstacionamientoNoVigenteYEstaEnElMismoPuntoGeograficoSeAlertaElInicioDelEstacionamiento() {
		
		when(gestorMock.tieneEstacionamientoVigente()).thenReturn(true);
		when(gestorMock.estaEnElMismoPuntoGeograficoDeInicioEstcaiomiento(coordenadaGPS)).thenReturn(true);
		
		sutApp.comenzoAManejar();

		verify(modoAppMock).alertaDeFinDeEstacionamiento(gestorMock);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Test 
	void testAlComenzarAManejarSeAlertaLaAccionYSeDelegaASuModo() {
		app.comenzoAManejar();
		
		verify(alerta).comenzoAManejar();
		verify(modo).comenzoAManejar(app, celular);
	}
	
	@Test
	void testAlComenzarACaminarSeAlertaLaAccionYSeDelegaASuModo() {
		app.comenzoACaminar();
		
		verify(alerta).comenzoACaminar();
		verify(modo).comenzoACaminar(app, patente, celular);
	}*/

}

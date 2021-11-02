package test_sem;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;

import sem.GestorSem;
import sem.ISemEstacionamiento;
import sem_celular.ISemCelular;
import sem_estacionamiento.Estacionamiento;
import sem_estacionamiento.EstacionamientoCompraApp;
import sem_estacionamiento.EstacionamientoCompraPuntual;
import sem_notificacion.INotificacion;
import sem_notificacion.NotificacionError;
import sem_notificacion.NotificacionFinalizacionEstacionamiento;
import sem_notificacion.NotificacionInicioDeEstacionamiento;

class GestorSemTest {
	
	GestorSem sutGestor;
	ISemEstacionamiento semEstacionamientoMock;
	EstacionamientoCompraPuntual estacionamientoCompraPuntualMock;
	EstacionamientoCompraApp estacionamientoCompraAppMock;
	ISemCelular celularMock;
	INotificacion notificacionMock;
	String patente;
	int nroCelular;
	LocalTime horaActual;
	LocalTime inicioJornada;
	LocalTime finJornada;
	int coordenadaEstacionamiento;
	
	@BeforeEach
	void setUp() throws Exception {
		patente = "Graph123";
		nroCelular = 11131313;
		coordenadaEstacionamiento = 4;
		finJornada = LocalTime.of(20, 00);
		inicioJornada = LocalTime.of(07, 00);
		horaActual = LocalTime.now();
		semEstacionamientoMock = mock(ISemEstacionamiento.class);
		estacionamientoCompraAppMock = mock(EstacionamientoCompraApp.class);
		estacionamientoCompraPuntualMock = mock(EstacionamientoCompraPuntual.class);
		notificacionMock = mock(INotificacion.class);
		celularMock = mock(ISemCelular.class);
		sutGestor = new GestorSem(semEstacionamientoMock, celularMock);
	}
	
	/**
	 * Este test solo funciona cuando al generar la compra puntual
	 * esta dentro de horio laboral
	 * */
	
	@Test
	void testMetodosGettersAndSetters() {	
		assertEquals(sutGestor.getCostoPorHora(), 40);
		assertEquals(sutGestor.getSemEstacionamiento(), semEstacionamientoMock);
		assertEquals(sutGestor.getFinDeJornada(), finJornada);
		assertEquals(sutGestor.getInicioDeJornada(), inicioJornada);
	}

	@Test
	void testGenerarEstacionamientoPuntualDentroDeJornadaLaboral() {	
		int horasTotales = 1;
		
		sutGestor.generarEstacionamientoPuntual(patente,coordenadaEstacionamiento, horasTotales);
		verify(semEstacionamientoMock).registrarEstacionamiento(any(Estacionamiento.class));
		assertEquals(LocalTime.now().plusHours(1).withNano(0), sutGestor.getHoraFinal().withNano(0));
	}
	
	//este test puede fallar de acuerdo al horario pero 
    //cuando son pasado las 20, se setea en el horario fin de la jornada laboal
	
	@Test
	void testErrorAlGenerarEstacionamientoPuntualFueraDeLaJornadaLaboral() {	
		int horasTotales = 15;
		sutGestor.generarEstacionamientoPuntual(patente, coordenadaEstacionamiento, horasTotales);
		
		verify(semEstacionamientoMock).registrarEstacionamiento(any(Estacionamiento.class));
		assertEquals(finJornada, sutGestor.getHoraFinal());
	}
	
	@Test
	void testFinalizarEstacionamientoOK() throws Exception {
	
		LocalTime horaInicio = LocalTime.of(16, 00);
		LocalTime horaFin = LocalTime.of(17, 50);
		
		when(semEstacionamientoMock.buscarEstacionamientoVigente(nroCelular)).thenReturn(estacionamientoCompraAppMock);
		when(estacionamientoCompraAppMock.getHoraDeInicio()).thenReturn(horaInicio);
		when(estacionamientoCompraAppMock.getHoraDeFinalizacion()).thenReturn(horaFin);
			
		assertTrue(sutGestor.finalizarEstacionamiento(nroCelular) instanceof NotificacionFinalizacionEstacionamiento);
	}
	
	@Test
	void testFinalizarEstacionamientoConErrorPorqueNoEstaRegistrado() throws Exception {
		LocalTime horaFin = LocalTime.of(17, 50);
		
		 when(semEstacionamientoMock.buscarEstacionamientoVigente(nroCelular))
	      .thenThrow(new Exception("Error"));
		 
		estacionamientoCompraAppMock.finalizar(horaFin);
		
		assertTrue(sutGestor.finalizarEstacionamiento(nroCelular) instanceof NotificacionError);
	}
	
	@Test
	void testFinalizarTodosLosEstacionamientos() {
		sutGestor.finalizarTodosLosEstacionamientos();
		verify(semEstacionamientoMock).finalizarTodosLosEstacionamientos(finJornada);
		
	}
		
	@Test
	void testInicializacionDeEstacionamientoOK() {
		
		when(celularMock.consultarSaldo(nroCelular)).thenReturn(200.0d);
		
	    sutGestor.iniciarEstacionamiento(patente,nroCelular, coordenadaEstacionamiento);
	    
		verify(semEstacionamientoMock).registrarEstacionamiento(any(Estacionamiento.class));
		
		assertTrue(sutGestor.iniciarEstacionamiento(patente,nroCelular, coordenadaEstacionamiento) instanceof NotificacionInicioDeEstacionamiento);
		
	}

	@Test
	void testNoSePuedeIniciarEstacionamientoPorSaldoInsuficiente() {
		
		when(celularMock.consultarSaldo(nroCelular)).thenReturn(0d);
		
	    sutGestor.iniciarEstacionamiento(patente,nroCelular, coordenadaEstacionamiento);
	    
		verify(semEstacionamientoMock, never()).registrarEstacionamiento(any(Estacionamiento.class));
		
		assertTrue(sutGestor.iniciarEstacionamiento(patente,nroCelular, coordenadaEstacionamiento) instanceof NotificacionError);
		
	}
	
	@Test
	void testActualizarHorarioMaximoLuegoDeUnaRecargaConUnEstacionamientoYaIniciadoOK() throws Exception {	
		double monto = 200;

		when(semEstacionamientoMock.buscarEstacionamientoVigente(nroCelular)).thenReturn(estacionamientoCompraAppMock);
		sutGestor.actualizarHorarioEstacionamiento(nroCelular, monto);
		verify(estacionamientoCompraAppMock).setHoraDeFinalizacion(any(LocalTime.class));
	}
	
	@Test
	void testActualizarHorarioMaximoLuegoDeUnaRecargaConUnEstacionamientoNOIniciadoError() throws Exception {	
		double monto = 200;
		 when(semEstacionamientoMock.buscarEstacionamientoVigente(nroCelular))
	      .thenThrow(new Exception("Error"));
		sutGestor.actualizarHorarioEstacionamiento(nroCelular, monto);
		verify(estacionamientoCompraAppMock, never()).setHoraDeFinalizacion(any(LocalTime.class));
	}

	@Test
	void testConsultarSaldo() {	
		sutGestor.consularSaldo(nroCelular);
		verify(celularMock).consultarSaldo(nroCelular);
	}
	
	@Test
	void testTieneEstacionamientoVigente() {	
		sutGestor.tieneEstacionamientoVigente(patente);
		verify(semEstacionamientoMock).tieneEstacionamientoVigente(patente);
	}
	
	@Test
	void testLaCoordenadaGPSDelCelularEstaDentroDeUnaZonaConIgualLaCoordenada() {	
		int coordenda = 12345;
		sutGestor.estaDentroDeUnaZonaConLaCoordenada(coordenda);
		verify(semEstacionamientoMock).estaDentroDeUnaZonaConLaCoordenada(coordenda);
	}
	
	@Test
	void testEstaEnElMismoPuntoGeograficoDeInicioEstaciomientoDelUsuario() {	
		int coordenda = 12345;
		sutGestor.estaEnElMismoPuntoGeograficoDeInicioEstaciomiento(coordenda, patente);
		verify(semEstacionamientoMock).estaEnElMismoPuntoGeograficoDeInicioEstaciomiento(coordenda, patente);
	}

}

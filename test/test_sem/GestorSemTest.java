package test_sem;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem.GestorSem;
import sem.ISemEstacionamiento;
import sem_celular.ISemCelular;
import sem_estacionamiento.Estacionamiento;
import sem_estacionamiento.EstacionamientoCompraApp;
import sem_estacionamiento.EstacionamientoCompraPuntual;

class GestorSemTest {
	
	GestorSem sutGestor;
	ISemEstacionamiento semEstacionamientoMock;
	EstacionamientoCompraPuntual estacionamientoCompraPuntualMock;
	EstacionamientoCompraApp estacionamientoCompraAppMock;
	ISemCelular celularMock;
	String patente;
	int nroCelular;
	//double saldo;
	LocalTime horaActual;
	LocalTime inicioJornada;
	LocalTime finJornada;

	@BeforeEach
	void setUp() throws Exception {
		//saldo = 200.0;
		patente = "Graph123";
		nroCelular = 11131313;
		finJornada = LocalTime.of(20, 00);
		inicioJornada = LocalTime.of(07, 00);
		horaActual = LocalTime.now();
		semEstacionamientoMock = mock(ISemEstacionamiento.class);
		estacionamientoCompraAppMock = mock(EstacionamientoCompraApp.class);
		estacionamientoCompraPuntualMock = mock(EstacionamientoCompraPuntual.class);
		celularMock = mock(ISemCelular.class);
		sutGestor = new GestorSem(semEstacionamientoMock, celularMock);
	}
	
	/**
	 * Este test solo funciona cuando al generar la compra puntual
	 * esta dentro de horio laboral
	 * */

	@Test
	void testGenerarEstacionamientoPuntualDentroDeJornadaLaboral() {	
		int horasTotales = 1;
		sutGestor.generarEstacionamientoPuntual(patente, horasTotales);
		verify(semEstacionamientoMock).registrarEstacionamiento(any(Estacionamiento.class));
		assertEquals(LocalTime.now().plusHours(1).withNano(0), sutGestor.getHoraFinal().withNano(0));
	}
	
	//este test puede fallar de acuerdo al horario pero 
    //cuando son pasado las 20, se setea en el horario fin de la jornada laboal
	
	@Test
	void testErrorAlGenerarEstacionamientoPuntualFueraDeLaJornadaLaboral() {	
		int horasTotales = 10;
		sutGestor.generarEstacionamientoPuntual(patente, horasTotales);
		verify(semEstacionamientoMock).registrarEstacionamiento(any(Estacionamiento.class));
		assertEquals(finJornada, sutGestor.getHoraFinal());
	}
	
	@Test
	void testFinalizarEstacionamientoOK() throws Exception {
		
		LocalTime horaInicio = LocalTime.of(16, 00);
		// redondeo el precio por minuto
		double precioPorMinuto = Math.round(0.6666666667 *100.0)/100.0;
		LocalTime horaFin = LocalTime.of(17, 50);
		LocalTime duracion = LocalTime.of(01, 50);
		double costoEsperado = (horaInicio.until(horaFin, ChronoUnit.MINUTES)) * precioPorMinuto;
		
		estacionamientoCompraAppMock.finalizar(horaFin);
		when(semEstacionamientoMock.buscarEstacionamientoVigente(nroCelular)).thenReturn(estacionamientoCompraAppMock);
		when(estacionamientoCompraAppMock.getHoraDeInicio()).thenReturn(horaInicio);
		when(estacionamientoCompraAppMock.getHoraDeFinalizacion()).thenReturn(horaFin);
		
		String notificacionEsperada = "Hora de Inicio: " + horaInicio + " /n " +
		           "Hora de Finalización: " + horaFin + " /n " +
		           "Duracion: " + duracion + " /n " +
		           "Costo " + costoEsperado;
		
		assertEquals(notificacionEsperada, sutGestor.finalizarEstacionamiento(nroCelular));
	}
	
	@Test
	void testFinalizarEstacionamientoConErrorPorqueNoEstaRegistrado() throws Exception {
		LocalTime horaFin = LocalTime.of(17, 50);
		 when(semEstacionamientoMock.buscarEstacionamientoVigente(nroCelular))
	      .thenThrow(new Exception("No se encontro un estacionamiento vigente con el numero de celular asocionado con: " + nroCelular ));
		estacionamientoCompraAppMock.finalizar(horaFin);
		
		assertEquals("No se encontro un estacionamiento vigente con el numero de celular asocionado con: " + nroCelular  , sutGestor.finalizarEstacionamiento(nroCelular));
	}
	
	@Test
	void testFinalizarTodosLosEstacionamientos() {
		sutGestor.finalizarTodosLosEstacionamientos();
		verify(semEstacionamientoMock).finalizarTodosLosEstacionamientos(finJornada);
		
	}
		
	/*@Test
	void testInicializacionDeEstacionamientoOK() {
		
		LocalTime horaInicio = LocalTime.of(16, 00);
		LocalTime horaFin = LocalTime.of(17, 50);
		when(celularMock.consultarSaldo(nroCelular)).thenReturn(200.0d);
	    sutGestor.iniciarEstacionamiento(patente,nroCelular);
		verify(semEstacionamientoMock).registrarEstacionamiento(estacionamientoCompraAppMock);
		
		String notificacionEsperada = "Hora de Inicio: " + horaInicio + " /n " +
		           "Hora de Finalización: " + horaFin + " /n " +
		           "Duracion: " + duracion + " /n " +
		           "Costo " + costoEsperado;
		
		assertEquals(notificacionEsperada, sutGestor.finalizarEstacionamiento(nroCelular));
		
	}
	*/

}

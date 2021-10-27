package test_sem;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem.GestorSem;
import sem.ISemEstacionamiento;
import sem_estacionamiento.Estacionamiento;
import sem_estacionamiento.EstacionamientoCompraPuntual;

class GestorSemTest {
	
	GestorSem sutGestor;
	ISemEstacionamiento semEstacionamientoMock;
	EstacionamientoCompraPuntual estacionamientoCompraPuntualMock;
	double monto;
	String patente;
	LocalTime horaActual;
	LocalTime inicioJornada;
	LocalTime finJornada;


	@BeforeEach
	void setUp() throws Exception {
		monto = 100;
		patente = "Graph123";
		finJornada = LocalTime.of(20, 00);
		inicioJornada = LocalTime.of(07, 00);
		horaActual = LocalTime.now();
		semEstacionamientoMock = mock(ISemEstacionamiento.class);
		estacionamientoCompraPuntualMock = mock(EstacionamientoCompraPuntual.class);
		sutGestor = new GestorSem(semEstacionamientoMock);
	}

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

}

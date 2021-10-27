package test_estacionamiento;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_estacionamiento.EstacionamientoCompraPuntual;

class EstacionamientoCompraPuntualTest {

	EstacionamientoCompraPuntual sut;

	@BeforeEach
	void setUp() throws Exception {
		
		LocalTime horaFinal = LocalTime.of(20, 00);
		String patente = "VAS930";
		int cantidadHoras = 2;
		sut = new EstacionamientoCompraPuntual(patente, cantidadHoras, horaFinal);
		
	}

	@Test
	void testCantidadDeHorasPedidas() {
		assertEquals(2, sut.getCantidadDeHoras());
	}
	
	@Test
	void testGetPatente() {
		assertEquals(sut.getPatente(), "VAS930");
	}
	
	@Test
	void testGetHoraInicioTest() {
		sut.setHoraDeInicio(LocalTime.of(10, 30));
		assertEquals(sut.getHoraDeInicio(), LocalTime.of(10, 30));
	}
	
	@Test
	void testGetHoraFinalizacionTest() {
		LocalTime horaFin = LocalTime.of(20, 00); 
		assertEquals(horaFin, sut.getHoraDeFinalizacion());
	}
	
	@Test
	void testEsEstacionamientoPuntualVigente() {
		assertTrue(sut.estacionamientoVigente());
	}
	
	
	// Este test funciona cuando la hora actual es menor que la hora final, en este caso las 09 : 50
	@Test
	void testNoEsEstacionamientoPuntualVigente() {
		LocalTime horaFinal = LocalTime.of(9, 50);
		sut.setHoraDeFinalizacion(horaFinal);
		assertFalse(sut.estacionamientoVigente());
	}


}

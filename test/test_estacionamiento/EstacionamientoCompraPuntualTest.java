package test_estacionamiento;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_estacionamiento.EstacionamientoCompraPuntual;

class EstacionamientoCompraPuntualTest {

	EstacionamientoCompraPuntual sut;
	LocalTime horaFinal;
	String patente;
	int cantidadHoras;
	int coordenada;
	int nroCelular;
	
	@BeforeEach
	void setUp() throws Exception {

		LocalTime horaFinal = LocalTime.of(20, 00);
		String patente = "VAS930";
		cantidadHoras = 2;
		coordenada = 5;
		nroCelular = 111111;
		sut = new EstacionamientoCompraPuntual(patente, horaFinal, coordenada, cantidadHoras);
		
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
	
	
	// Este test puede fallar, ya que la hora de finalizacion tiene que ser menor a la hora actual
	@Test
	void testEsEstacionamientoPuntualVigente() {
		assertTrue(sut.estacionamientoVigente());
	}
	
	
	// Este test funciona cuando la hora actual es menor que la hora final, en este caso las 09 : 50
	@Test
	void testNoEsEstacionamientoPuntualVigente() {
		LocalTime horaFinal = LocalTime.of(7, 00);
		sut.setHoraDeFinalizacion(horaFinal);
		assertFalse(sut.estacionamientoVigente());
	}
	
	@Test
	void testEsEstablecerHoraFinEstacionamiento() {
		sut.establecerHoraFinEstacionamiento(horaFinal);
		assertEquals(sut.getHoraDeFinalizacion(), horaFinal);
	}
	
	@Test
	void testNoSonNumerosIgualesPorqueEstacionamientoPuntualNoTiene() {
		assertFalse(sut.sonNumerosIguales(nroCelular));
	}
	


}

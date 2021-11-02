package test_estacionamiento;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_estacionamiento.EstacionamientoCompraApp;

class EstacionamientoAppTest {
	
	EstacionamientoCompraApp sut;
	LocalTime horaMaxima;

	@BeforeEach
	void setUp() throws Exception {
		horaMaxima = LocalTime.of(18, 00);
		String patente = "NPM239";
		int numeroCelular = 111872727;
		int coordenada = 5;
		sut = new EstacionamientoCompraApp(patente, horaMaxima,coordenada, numeroCelular);
	}

	@Test
	void testEsEstacionamientoAppFinalizadoPorEndeNoEstaVigente() {
		LocalTime horafin = LocalTime.of(17, 00);
		sut.finalizar(horafin);
		assertFalse(sut.estacionamientoVigente());
	}
	
	@Test
	void testEsEstacionamientoAppVigente() {
		assertTrue(sut.estacionamientoVigente());
	}
	
	@Test
	void testHoraDeFinalizacionLuegoDeFinalizarElEstacionamientoViaAPP() {
		LocalTime horafin = LocalTime.of(17, 30);
		sut.finalizar(horafin);
		assertEquals(horafin, sut.getHoraDeFinalizacion());
	}
	
	@Test
	void testHorarioMaximoAntesDeFinalizarElEstacionamiento() {
		assertEquals(horaMaxima, sut.getHoraDeFinalizacion());
	}

}

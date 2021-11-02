package test_estacionamiento;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_estacionamiento.EstacionamientoCompraApp;

class EstacionamientoAppTest {
	
	EstacionamientoCompraApp sut;
	LocalTime horaMaxima;
	int numeroCelular;
	int coordenada;
	String patente;

	@BeforeEach
	void setUp() throws Exception {
		horaMaxima = LocalTime.of(18, 00);
		patente = "NPM239";
		numeroCelular = 111872727;
		coordenada = 5;
		sut = new EstacionamientoCompraApp(patente,horaMaxima,coordenada,numeroCelular);
	}
	
	@Test
	void testGettersAndSetters() {
		
		//Setters
		sut.setEstaVigente(true);
		sut.setHoraDeFinalizacion(horaMaxima);
		sut.setHoraDeInicio(LocalTime.now());
		sut.setNumeroDeCelular(numeroCelular);
		sut.setPatente(patente);
		
		//Getters
		assertEquals(sut.getEstaVigente(), true);
		assertEquals(sut.getHoraDeFinalizacion(), horaMaxima);
		assertEquals(sut.getNumeroDeCelular(), numeroCelular);
		assertEquals(sut.getPuntoGeografico(), coordenada);
		assertEquals(sut.getPatente(), patente);
		assertEquals(sut.getHoraDeInicio().withNano(0), LocalTime.now().withNano(0));
		
		
	}
	
	@Test
	void testSonNumerosDeCelularesIguals() {
		assertTrue(sut.sonNumerosIguales(numeroCelular));
	}
	
	@Test
	void testEstablecerHoraDeFinDeEstacionamiento() {
		sut.establecerHoraFinEstacionamiento(horaMaxima);
		assertEquals(sut.getHoraDeFinalizacion(), horaMaxima);
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
	
	@Test
	void testFinalizarEstacionamiento() {
		assertEquals(horaMaxima, sut.getHoraDeFinalizacion());
	}
	
	



}

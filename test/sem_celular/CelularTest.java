package sem_celular;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CelularTest {
	
	SemCelular sutCelular;
	double montoRecarga;
	int nroCelular;

	@BeforeEach
	void setUp() throws Exception {
		sutCelular = new SemCelular();
		nroCelular = 1162882809;
		montoRecarga = 500;
	}

	@Test
	void testRegistrarNumeroDeTelefonno() {
		sutCelular.registrarNumero(nroCelular);
		assertEquals(1,sutCelular.getCelulares().size());
	}
	
	@Test
	void testAlRegistrarVerificoQueElSaldoSea0() {
		sutCelular.registrarNumero(nroCelular);
		assertEquals(0.0,sutCelular.getCelulares().get(nroCelular));
	}
	
	@Test
	void testCuandoSeIntentaBuscarElCelularQueYaFueRegistradoEsTrue() {
		sutCelular.registrarNumero(nroCelular);
		assertTrue(sutCelular.elCelularYaEstaRegistrado(nroCelular));
	}
	
	@Test
	void testCuandoSeIntentaBuscarElCelularQueNoFueRegistradoEsFalse() {
		assertFalse(sutCelular.elCelularYaEstaRegistrado(nroCelular));
	}
	
	// El monto al registrarlo es 0.0
	@Test
	void testRealizarRecargaConUnCelularYaRegistrado() {
		sutCelular.registrarNumero(nroCelular);
		sutCelular.recargarSaldo(montoRecarga, nroCelular);
		assertEquals(sutCelular.consultarSaldo(nroCelular), 500.0d);
	}
	
	@Test
	void testRealizarRecargaConUnCelularQueNoFueRegistrado() {
		sutCelular.recargarSaldo(montoRecarga, nroCelular);
		assertEquals(sutCelular.consultarSaldo(nroCelular), 500.0d);
	}
	
	@Test
	void testRealizarRecargaConUnCelularRegistradoYConUnMontoPrevio() {
		sutCelular.registrarNumero(nroCelular);
		sutCelular.recargarSaldo(montoRecarga, nroCelular);
		sutCelular.recargarSaldo(montoRecarga, nroCelular);
		assertEquals(sutCelular.consultarSaldo(nroCelular), 1000.0d);
	}
	
	@Test
	void testDescontarCreditoAUnCeluar() {
		sutCelular.registrarNumero(nroCelular);
		sutCelular.recargarSaldo(montoRecarga, nroCelular);
		double montoADescontar = 200;
		sutCelular.descontarSaldo(nroCelular, montoADescontar);
		assertEquals(sutCelular.consultarSaldo(nroCelular), 300.0d);
	}
	
}

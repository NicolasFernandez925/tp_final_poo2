package test_notificacion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_notificacion.NotificacionAlertaConsultaDeSaldo;

class NotificacionAlertaConsultaDeSaldoTest {
	
	NotificacionAlertaConsultaDeSaldo notificacion;
	double saldo;
	int nroCelular;

	@BeforeEach
	void setUp() throws Exception {
		
		saldo = 400.0;
		nroCelular = 28171626;
		notificacion = new NotificacionAlertaConsultaDeSaldo(saldo, nroCelular);
	}

	@Test
	void testMensajeNotificacionRecibida() {
		String msgEsperado = "El saldo actual del Nro.: " + nroCelular + " es de: " + saldo;
		assertEquals(notificacion.mensaje(), msgEsperado);
	}

}

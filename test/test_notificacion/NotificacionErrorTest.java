package test_notificacion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_notificacion.NotificacionAlertaDeEstacionamiento;
import sem_notificacion.NotificacionError;

class NotificacionErrorTest {

	NotificacionError notificacion;
	String msg;

	@BeforeEach
	void setUp() throws Exception {
		
		msg = "Test notificacion con error";
		notificacion = new NotificacionError(msg);
	}

	@Test
	void testMensajeNotificacionRecibida() {
		assertEquals(notificacion.mensaje(), msg);
	}

}

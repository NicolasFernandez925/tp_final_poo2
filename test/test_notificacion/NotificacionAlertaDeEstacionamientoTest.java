package test_notificacion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_notificacion.INotificacion;
import sem_notificacion.NotificacionAlertaDeEstacionamiento;

class NotificacionAlertaDeEstacionamientoTest {
	
	NotificacionAlertaDeEstacionamiento notificacion;
	String msg;

	@BeforeEach
	void setUp() throws Exception {
		
		msg = "Test notificacion";
		notificacion = new NotificacionAlertaDeEstacionamiento(msg);
	}

	@Test
	void testMensajeNotificacionRecibida() {
		assertEquals(notificacion.mensaje(), msg);
	}

}

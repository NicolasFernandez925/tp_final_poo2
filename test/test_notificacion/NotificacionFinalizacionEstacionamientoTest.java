package test_notificacion;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_notificacion.NotificacionAlertaConsultaDeSaldo;
import sem_notificacion.NotificacionFinalizacionEstacionamiento;

class NotificacionFinalizacionEstacionamientoTest {

	NotificacionFinalizacionEstacionamiento notificacion;
	LocalTime horasConsumidas;
	LocalTime horaDeInicio;
	LocalTime horaDeFinalizacion;
	double costo;

	@BeforeEach
	void setUp() throws Exception {
		
		horasConsumidas = LocalTime.of(2, 00);
		horaDeInicio = LocalTime.of(16, 00);
		horaDeFinalizacion = LocalTime.of(18, 00);
		costo = 400.0;
		notificacion = new NotificacionFinalizacionEstacionamiento(horasConsumidas, horaDeInicio,horaDeFinalizacion,costo);
	}

	@Test
	void testMensajeNotificacionRecibida() {
		String msgEsperado = "Hora de Inicio: " + horaDeInicio + " /n " +
		           "Hora de Finalización: " + horaDeFinalizacion + " /n " +
		           "Duracion: " + horasConsumidas + " /n " +
		           "Costo " + costo;
		assertEquals(notificacion.mensaje(), msgEsperado);
	}

}

package test_notificacion;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_notificacion.NotificacionInicioDeEstacionamiento;

class NotificacionInicioDeEstacionamientoTest {
	
	LocalTime horaDeInicio;
    LocalTime horaDeFinalizacion;
    NotificacionInicioDeEstacionamiento notificacion;

	@BeforeEach
	void setUp() throws Exception {
		horaDeInicio = LocalTime.of(16, 00);
		horaDeFinalizacion = LocalTime.of(18, 00);
		notificacion = new NotificacionInicioDeEstacionamiento(horaDeInicio,horaDeFinalizacion);
	}

	@Test
	void testMensajeNotificacionRecibida() {
		
		String msgEsperado = "Hora de Inicio: " + horaDeInicio + " /n " +
		        			 "Hora de Finalización: " + horaDeFinalizacion;
		assertEquals(notificacion.mensaje(), msgEsperado);
	}

}

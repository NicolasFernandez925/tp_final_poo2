package sem_notificacion;

import java.time.LocalTime;

public class NotificacionInicioDeEstacionamiento implements INotificacion {
	
	private LocalTime horaDeInicio;
    private LocalTime horaDeFinalizacion;
	
	public NotificacionInicioDeEstacionamiento(LocalTime horaDeInicio, LocalTime horaDeFinalizacion) {
		super();
		this.horaDeInicio = horaDeInicio;
		this.horaDeFinalizacion = horaDeFinalizacion;
	}

	@Override
	public String mensaje() {
		return "Hora de Inicio: " + horaDeInicio + " /n " +
		        "Hora de Finalización: " + horaDeFinalizacion;
	}

}

package sem_notificacion;

import java.time.LocalTime;

public class NotificacionFinalizacionEstacionamiento implements INotificacion {

	private LocalTime horasConsumidas;
	private LocalTime horaDeInicio;
	private LocalTime horaDeFinalizacion;
	private double costo;
	
	public NotificacionFinalizacionEstacionamiento(LocalTime horasConsumidas, LocalTime horaDeInicio,
			LocalTime horaDeFinalizacion, double costo) {
		super();
		this.horasConsumidas = horasConsumidas;
		this.horaDeInicio = horaDeInicio;
		this.horaDeFinalizacion = horaDeFinalizacion;
		this.costo = costo;
	}

	@Override
	public String mensaje() {
		return "Hora de Inicio: " + horaDeInicio + " /n " +
		           "Hora de Finalización: " + horaDeFinalizacion + " /n " +
		           "Duracion: " + horasConsumidas + " /n " +
		           "Costo " + costo;
	}

}

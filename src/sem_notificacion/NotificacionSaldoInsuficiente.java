package sem_notificacion;

public class NotificacionSaldoInsuficiente implements INotificacion{

	@Override
	public String mensaje() {
		return "Saldo insuficiente. Estacionamiento no permitido.";
	}

}

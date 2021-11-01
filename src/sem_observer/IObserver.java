package sem_observer;

import sem_notificacion.INotificacion;

public interface IObserver {
	void recibirAlertaFinEstacionamiento(INotificacion notificacion);
	void recibirAlertaRecarga(INotificacion notificacion);
	void recibirAlertaInicioEstacionamiento(INotificacion notificacion);
}

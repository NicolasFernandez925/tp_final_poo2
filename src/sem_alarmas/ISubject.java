package sem_alarmas;

import sem_notificacion.INotificacion;

public interface ISubject {
	void suscribir(IObserver ob);
	void desuscribir(IObserver ob);
	void notificarInicioEstacionamiento(INotificacion notificacion);
	void notificarFinalizacioNEstacionamiento(INotificacion notificacion);
	void notiticacionRecargaSaldo(INotificacion notificacion);
}

package sem_observer;

import sem_notificacion.INotificacion;

public interface ISubject {
	void suscribir(IObserver ob);
	void desuscribir(IObserver ob);
	void notificarInicioEstacionamiento(INotificacion notificacion);
	void notificarFinalizacionEstacionamiento(INotificacion notificacion);
	//void notiticacionRecargaSaldo(INotificacion notificacion);
}

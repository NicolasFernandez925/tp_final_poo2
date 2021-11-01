package sem_observer;

public interface ISubject {
	void suscribir(IObserver ob);
	void desuscribir(IObserver ob);
	void notificarInicioEstacionamiento();
	void notificarFinalizacioNEstacionamiento();
	void notiticacionRecargaSaldo();
}

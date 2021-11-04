package sem_alarmas;

import java.util.HashSet;
import java.util.Set;
import sem_notificacion.INotificacion;

public class AlarmaEstacionamiento implements ISubject {
	Set<IObserver> suscriptores = new HashSet<IObserver> ();

	@Override
	public void suscribir(IObserver ob) {
		suscriptores.add(ob);
	}

	@Override
	public void desuscribir(IObserver ob) {
		if(suscriptores.contains(ob)) {
			suscriptores.remove(ob);
		}		
	}

	@Override
	public void notificarInicioEstacionamiento(INotificacion notificacion) {
		this.suscriptores.stream().forEach(s -> s.recibirAlertaInicioEstacionamiento(notificacion));
		
	}

	@Override
	public void notificarFinalizacionEstacionamiento(INotificacion notificacion) {
		this.suscriptores.stream().forEach(s -> s.recibirAlertaFinEstacionamiento(notificacion));
		
	}

	/*@Override
	public void notiticacionRecargaSaldo(INotificacion notificacion) {
		this.suscriptores.stream().forEach(s -> s.recibirAlertaRecarga(notificacion));
		
	}*/
}

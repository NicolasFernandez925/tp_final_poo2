package sem_celular;

import java.util.HashMap;
import java.util.Map;

public class SemCelular {

	private Map<Integer, Double> celulares;
	
	public SemCelular() {
		this.celulares = new HashMap<Integer,Double>();
	}
	
	/**
	 * @param creditoARecargar : double, representa la cantidad a cargar
	 * @param nroCelular : nroCelular int, representa el nro al cual se le va realizar la recarga
	 * @return retorna el saldo previo + el de la recarga, en caso que este registrado el nroCelular,
	 * caso contrario registra el numero con y luego realiza dicha recarga.
	 * */
	
	public void recargarSaldo(double creditoARecargar, int nroCelular) {
		if(this.elCelularYaEstaRegistrado(nroCelular)) {
			this.recargar(creditoARecargar, nroCelular);
		}
		else {
			this.registrarNumero(nroCelular);
			this.recargar(creditoARecargar, nroCelular);
		}
	
	}

	public void recargar(double creditoARecargar, int nroCelular) {
		double saldoAnterior = this.getSaldo(nroCelular);
		saldoAnterior += creditoARecargar;
		this.getCelulares().put(nroCelular, saldoAnterior);		
	}

	public double consultarSaldo(int nroCelular) {
		double saldo = this.getSaldo(nroCelular);
		return saldo;
	}
	
	public void registrarNumero(int nroCelular) {
			this.getCelulares().put(nroCelular, 0.0);
	}
	
	public boolean elCelularYaEstaRegistrado(int nroCelular) {
		return this.getCelulares().containsKey(nroCelular);
	}

	public Map<Integer, Double> getCelulares(){
		return this.celulares;
	}
	
	private double getSaldo(int nroCelular) {
		return this.getCelulares().get(nroCelular);
	}
}

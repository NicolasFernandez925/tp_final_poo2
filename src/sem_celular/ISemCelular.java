package sem_celular;

public interface ISemCelular {
	public void recargarSaldo(double monto, int celular);
	public void descontarSaldo(int celular, double monto);
	public double consultarSaldo(int celular);
}

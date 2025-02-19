
public class ContaBancaria extends Conta {

	public ContaBancaria(int n, double s) {
		super(n,s);
	}
	
	public void depositar(double valor) {
		saldo = saldo + valor;
	}
	
	public boolean sacar(double valor) {
		if(valor<= saldo) {
			saldo-=valor;
			return true;
		}
		else {
			return false;
		}
	}
}

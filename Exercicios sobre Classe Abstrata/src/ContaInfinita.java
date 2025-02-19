
public class ContaInfinita extends Conta {
	
	public ContaInfinita(int n, double s) {
		super(n,s);
	}
	
	public void depositar(double valor) {
		saldo+=valor + 5;
	}
	
	public boolean sacar(double valor) {
		saldo-=valor;
		return true;
	}
}

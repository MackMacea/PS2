
public class Conta {
	private String nome;
	private double saldo;
	
	public Conta (String nome, double saldo) {
		this.nome = nome;
		this.saldo = saldo;
	}
	
	public void depositar(double valor) {
		if(valor<0) {
			throw new DepositoInvalidoException();
		}
		saldo +=valor;
	}
	
	public boolean sacar(double valor) {
		if(valor> saldo) {
			return false;
		}
		saldo-=valor;
		return true;
	}
	
	public String toString() {
		return "Conta de " + nome + "tem R$" + saldo;
	}
}

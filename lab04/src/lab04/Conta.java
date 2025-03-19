package lab04;

public class Conta {

	public Conta(long nro_conta, double saldo) {
		this.nro_conta = nro_conta;
		this.saldo = saldo;
	}
	
	long nro_conta;
	double saldo;
	
	@Override
	public String toString() {
		return "Conta de numero :" + nro_conta + " possui: " + saldo;
	}
	
	public long getNmr() {
		return nro_conta;
	}
	
	public double getSaldo() {
		return saldo;
	}
}

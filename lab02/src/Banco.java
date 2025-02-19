import java.util.ArrayList;
public class Banco {
	
	private String nome;
	private ArrayList<Conta> contas;
	
	public Banco(String nome) {
		this.nome = nome;
		contas = new ArrayList<>();
	}
	
	public void adicionar(Conta c) {
		contas.add(c);
		System.out.println("Adicionada");
	}
	
	public void mostrar() {
		System.out.println("\nContas do Banco " + nome +" :");
		for(Conta c : contas) {
			System.out.println(c);
		}
	}
	
	public void premiarInfinitas() {
		for(Conta c: contas) {
			if(c instanceof ContaInfinita) {
				c.depositar(1000);
			}
		}
	}
	
	public void tentarSacar(double v) {
		for(Conta c: contas) {c.sacar(v);}
	}
	
	public void aumentarLimiteEspeciais(double v) {
		for(Conta c: contas) {
			if (c instanceof ContaEspecial) {
				ContaEspecial e = (ContaEspecial) c;
				e.aumentar(v);
			}
		}
	}

}

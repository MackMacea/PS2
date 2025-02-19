import java.util.Scanner;
public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("-------------------");
		System.out.println("Bem vindo Campeão!");
		System.out.println("-------------------");
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Nome do Correntista:");
		String nome = entrada.nextLine();
		boolean teste = false;
		while(!teste) {
			System.out.println("Informe o saldo do Cliente:");
			
			try {
				double saldo = Double.parseDouble(entrada.nextLine());
				teste = true;
				Conta c = new Conta(nome,saldo);
				System.out.println(c);
			}
			
			catch(NumberFormatException ex){
				System.out.println("Digitação invalida!");
				System.out.println("Mensagem de Execução: " + ex.getMessage());
			}
		}
		System.out.println("Fim do Programa!");
		entrada.close();
	}

}

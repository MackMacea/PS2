package ps2.teoria06;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import static java.lang.System.out;

import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	private TitularRepo titularRepo;

	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) {
		boolean sair = false;
		while (!sair) {
			out.println("## GERENCIADOR DE TITULARES ##");
			out.println("(1) Criar titular");
			out.println("(2) Ler todos os titulares");
			out.println("(3) Ler um titular específico");
			out.println("(4) Alterar titular");
			out.println("(5) Apagar titular");
			out.println("(0) Sair");
			out.print("Escolha uma opção: ");
			int opcao = Integer.parseInt(entrada.nextLine());
			switch(opcao) {
				case 1: criar(); break; 
				case 2: lerTodos(); break; 
				case 3: ler(); break;
				case 4: alterar(); break;
				case 5: apagar(); break;
				case 0: sair = true; break;
				default:
					out.println("## Opção inválida! ##");
			}
		}
	}	

	public void criar() {
		out.print("# Id do novo titular: ");
		long id = Long.parseLong(entrada.nextLine());
		out.print("# Nome do novo titular: ");
		String nome = entrada.nextLine();
		out.print("# CPF do novo titular: ");
		String cpf = entrada.nextLine();
		Titular t = new Titular(id, nome, cpf);
		titularRepo.save(t);
	}
	public void lerTodos() {
		Iterable<Titular> titulares=titularRepo.findAll();
		out.println("titulares cadastrados: ");
		for(Titular t: titulares){
			out.println(t.getId() + " - " + t.getNome() + " - " + t.getCpf() );
		}
	}
	public void ler() {
		out.print("# Id do titular desejado: ");
		long id = Long.parseLong(entrada.nextLine());
		Optional<Titular> teste = titularRepo.findById(id);
		if(teste.isPresent()) {
			Titular t = teste.get();
			out.println(t.getId() + " - " + t.getNome() + " - " + t.getCpf() );
		}
		else {
			out.print("Falha ao identificar titular");
		}
		
			
	} 
	public void alterar() {
		out.print("# Id do titular: ");
		long id = Long.parseLong(entrada.nextLine());
		Optional<Titular> teste = titularRepo.findById(id);
		if(teste.isPresent()) {
			Titular t = teste.get();
			out.println(t.getId() + " - " + t.getNome() + " - " + t.getCpf() );
		}
		Titular t = teste.get();
		int varia = 0;
		out.print("Qual informação dever ser alterada?");
		out.print("\n1-Nome");
		out.print("\n2-CPF");
		int opc = Integer.parseInt(entrada.nextLine());
		switch(opc) {
		case 1: varia = 1; break;
		case 2 :varia = 2; break;
		default: out.print("Invalido");break;
		}
		
		if(varia==1) {
			out.print("# Nome do novo titular: ");
			String nome = entrada.nextLine();
			t.setNome(nome);
		}
		if(varia==2) {
			out.print("# CPF do novo titular: ");
			String cpf = entrada.nextLine();
			t.setCpf(cpf);
		}
		
		titularRepo.save(t);
		
		
		
	
		
		
		
	}
	public void apagar() {
		out.print("# Id do titular que será apagado: ");
		long id = Long.parseLong(entrada.nextLine());
		titularRepo.deleteById(id);
		out.print("Titular deletado com sucesso");
	}
}

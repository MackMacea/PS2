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
	private ProfessorRepo professorRepo;

	@Autowired
	private FaculdadeRepo faculdadeRepo;

	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) {
		
		boolean teste = false;
		while(!teste) {
			int opc ;
			out.println("\nGerenciador de Universidade");
			out.println("1 - Cadastrar Faculdades ");
			out.println("2 - Listar Faculdades");
			out.println("3 - Cadastrar Professor");
			out.println("4 - Listar Professores");
			out.println("5 - Sair");
			out.println("\n Qual função deseja acessar?:");
			opc = Integer.parseInt(entrada.nextLine());
			switch(opc) {
			
			case 1:cadastrarFaculdade(); break;
			case 2 :listarFaculdades();break;
			case 3: cadastrarProfessor();break;
			case 4: listarProfessores();break;
			case 5 : teste = true; break;
			
			default : out.println("INVALIDO");
			}
			
			
		}
		out.println("Fim de programa");
	}
	
	public void cadastrarFaculdade() {
		out.println("Qual o nome da faculdade?");
		String nome = entrada.nextLine();
		out.println("Qual o ano de fundação da: "+nome );
		int ano = Integer.parseInt(entrada.nextLine());
		Faculdade f = new Faculdade(nome, ano);
		faculdadeRepo.save(f);
		out.println("Faculdade cadastrada com sucesso!");
		
	}
	
	public void listarFaculdades() {
		Iterable<Faculdade> faculdades = faculdadeRepo.findAll();
		for(Faculdade f: faculdades) {
			out.println("(" + f.getId() +")" + f.getNome()+"  -  "+f.getAnoFundacao());
		}
	}
	
	public void cadastrarProfessor() {
		out.println("Nome do professor: ");
		String nome  = entrada.nextLine();
		out.println("CPF do professor: ");
		String cpf = entrada.nextLine();
		out.println("Matricula do professor: ");
		int matricula = Integer.parseInt(entrada.nextLine());
		out.println("Selecione a faculdade que o professor deve ser alocado: ");
		listarFaculdades();
		out.println("id da faculdade selecionada: ");
		Long opc = Long.parseLong(entrada.nextLine());
		Optional<Faculdade> f = faculdadeRepo.findById(opc);
		if(f.isPresent()) {
			Faculdade faculdade = f.get();
			Professor p = new Professor(nome,cpf,matricula,faculdade);
			professorRepo.save(p);
			out.println("Professor criado com sucesso!");
		}
		else {
			out.println("Falha ao indentificar a faculdade selecionada!");
		}
		

		}

	public void listarProfessores() {
		Iterable<Professor> professores = professorRepo.findAll();
		for(Professor p:professores) {
			out.println("ID  " + p.getId()+"   " + p.getNome()+ "    " + p.getFaculdade().getNome());
		}
	}
}
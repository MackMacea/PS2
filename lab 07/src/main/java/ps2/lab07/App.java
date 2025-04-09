package ps2.lab07;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import java.util.*;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	private MusicaRepo musicaRepo;

	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) {
		boolean teste = false;
		while(!teste){
				int opc = 0;
				System.out.println("ESCOLHA UMA OPÇÃO:");
				System.out.println("1 - ADICIONAR MUSICA");
				System.out.println("2 - REMOVER MUSICA");
				System.out.println("3 - ALTERAR MUSICA");
				System.out.println("4 - LISTAR MUSICAS");
				System.out.println("5 - SAIR");
				opc = Integer.parseInt(entrada.nextLine());

				switch(opc){
					case 1: adicionarMusica();break;
					case 2: removerMusica(); break;
					case 3: alterarMusica();break;
					case 4: listarMusica();break;
					case 5: teste = true; break;
					default: System.out.println("INVALIDO");
				}
		}

	}
	
	private void adicionarMusica(){
		String titulo;
		String compositor;
		int ano;
		System.out.println("Nome da musica: ");
		titulo = entrada.nextLine();
		System.out.println("Compositor da musica: ");
		compositor = entrada.nextLine();
		System.out.println("Ano de lançamento da musica: ");
		ano = Integer.parseInt(entrada.nextLine());
		Musica m = new Musica(titulo,compositor,ano);
		musicaRepo.save(m);
		System.out.println("Musica salva com sucesso");
	}

	public void listarMusica(){

		Iterable<Musica> musicas = musicaRepo.findAll();

		for(Musica m:musicas){
			System.out.println(m.toString());
			System.out.println("");
		}
	}

	public void removerMusica(){
		listarMusica();
		System.out.println("Qual o ID da musica que deseja deletar?: ");
		Long selecionada = Long.parseLong(entrada.nextLine());
		Optional<Musica> m = musicaRepo.findById(selecionada);
		if(m.isPresent()){
			Musica mus = m.get();
			musicaRepo.delete(mus);
		}
		else{
			System.out.println("Erro ao indentificar a musica apresentada");
		}
	}

	public void alterarMusica(){
		listarMusica();
		System.out.println("Qual o ID da musica que deseja alterar?");
		Long selecionada = Long.parseLong(entrada.nextLine());

		Optional <Musica> m = musicaRepo.findById(selecionada);
		if(m.isPresent()){
			Musica mus = m.get();
			String titulo;
			String compositor;
			int ano;
			System.out.println("novo nome da musica: ");
			titulo = entrada.nextLine();
			System.out.println("novo compositor da musica: ");
			compositor = entrada.nextLine();
			System.out.println("novo ano de lançamento da musica: ");
			ano = Integer.parseInt(entrada.nextLine());
			mus.setTitulo(titulo);
			mus.setCompositor(compositor);
			mus.setAno(ano);
			musicaRepo.save(mus);
			System.out.println("MUSICA ALTERADA COM SUCESSO!");
		}
		else{
			System.out.println("Não foi possivel encontrar a musica");
		}
	}

}
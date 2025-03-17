package lab03;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class GerenciadorNomesArq implements GerenciadorNomes {
	private List<String> nomes = new ArrayList<String>();
	Path path = Paths.get("D:\\PS2 pratica\\lab03\\src\\lab03\\nomes.txt");
	
	//preenchendo lista
	
	public void abrirArq() throws Exception {
		nomes = Files.readAllLines(path);
	}
	
	@Override
	public List<String> obterNomes(){
		try {
			abrirArq();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nomes;
	}
	
	@Override
	public void adicionarNome(String nome) {
	    try {
			Files.writeString(path, "\n"+ nome, 
			        StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			abrirArq();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

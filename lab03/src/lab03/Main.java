package lab03;

public class Main {
		public static void main(String[] args) {
			GerenciadorNomes gNomes = new GerenciadorNomesArq();
			Ihm Ihm = new Ihm(gNomes);
			Ihm.dialogar();
		}
}

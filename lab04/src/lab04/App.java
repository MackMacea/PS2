package lab04;

import java.util.Scanner;
import java.util.List;

public class App{
	 private static Scanner entrada = new Scanner(System.in);
	 private static Facilitador fac = null;
	 
	 
	 private static void consultar() throws Exception {
		 List<Conta> contas = fac.receberContas();
		 for(Conta c: contas) {
			 System.out.println(c);
		 }
	 }
	 
	 private static void adicionar() throws Exception{
		 System.out.println("Qual o numero da nova conta?");
		 long n = Long.parseLong(entrada.nextLine());
		 System.out.println("Qual o saldo da nova conta?");
		 double s = Double.parseDouble(entrada.nextLine());
		 Conta c = new Conta(n,s);
		 boolean ok = fac.adicionarConta(c);
		 
		 if(ok) {
			 System.out.println("CONTA CRIADA");
		 }
		 else {
			 System.out.println("ERRO AO CRIAR CONTA");
		 }
	 }
	 
	 private static void remover() throws Exception {
		 System.out.println("Qual o numero da conta que deve ser removida?");
		 long n = Long.parseLong(entrada.nextLine());
		 List<Conta> contas = fac.receberContas();
		 boolean existTest = false;
		 for(Conta c:contas) {
			 if(c.getNmr() == n) {
				 existTest = true;
			 }
		 }
		 if(existTest) {
			 boolean teste = fac.apagarConta(n);
			 if(teste) {
				 System.out.println("CONTA APAGADA COM SUCESSO");
				 
			 }
			 else {
				 System.out.println("ERRO AO APAGAR CONTA!");
			 }
		 }
		 else {
			 System.out.println("CONTA COM O NUMERO " +n +" NÃO EXISTE");
		 }
	 }
	 
	 
	 public static void alterar() throws Exception {
		 System.out.println("Qual o numero da conta que deve ser alterada?");
		 long n = Long.parseLong(entrada.nextLine());
		 List<Conta> contas = fac.receberContas();
		 boolean existTest = false;
		 for(Conta c:contas) {
			 if(c.getNmr() == n) {
				 existTest = true;
			 }
		 }
		 if(existTest) {
			 System.out.println("Informe o novo saldo da conta: ");
			 double novoSaldo = Double.parseDouble(entrada.nextLine());
			 Conta c = new Conta(n,novoSaldo);
			 boolean teste = fac.alterarConta(c);
			 if(teste) {
				 System.out.println("CONTA ALTERADA COM SUCESSO");
				 
			 }
			 else {
				 System.out.println("ERRO AO ALTERAR CONTA!");
			 }
		 }
		 else {
			 System.out.println("CONTA COM O NUMERO " +n +" NÃO EXISTE");
		 }		 
	 }
	 
	 
	 
	 
	 
	 public static void main(String[] args) throws Exception {
		 String url = "jdbc:postgresql://db.teuzfyjadnsylqrnlkus.supabase.co:5432/postgres?user=postgres&password=P4My_C6xiVGjHRy";
		 fac = new Facilitador (url);
		 
		 boolean opc = false;
		 while(!opc) {
			 System.out.println("\nBEM VINDO!");
			 System.out.println("1 - consultar dados");
			 System.out.println("2 - adicionar dados");
			 System.out.println("3 - remover dados");
			 System.out.println("4 - alterar dados ");
			 System.out.println("5 - sair");
			 System.out.println("Escolha uma opção: ");
			 int opcao = Integer.parseInt(entrada.nextLine());
			 switch (opcao) {
			 
			 case 1 : consultar(); break;
			 case 2 : adicionar(); break;
			 case 3 : remover(); break;
			 case 4 : alterar(); break;
			 case 5 : opc =true;break;
			 default : System.out.println("INVÁLIDO!");
			 }
			 
			 
		 }
	 }
}
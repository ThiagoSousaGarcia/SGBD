import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) {
		
		int verific = 1, aux;
		String resposta = null, r = null;

		Hash obj = new Hash();

		while(verific == 1){
			System.out.println("1 - Buscar");
			System.out.println("2 - Incluir");
			System.out.println("3 - Excluir");
			System.out.println("9 - Sair");
			System.out.println("Digite a opcao:\n");
			Scanner ler = new Scanner(System.in);
	    	int opcao = ler.nextInt();
			switch (opcao) {
				case 1:
					System.out.println("Digite a chave de busca");
					r = ler.next();
					resposta = obj.buscar(r);
					System.out.println(resposta);
					break;
				case 2:
					System.out.println("Digite a chave a ser incluida");
					r = ler.next();
					aux = obj.incluir(r);
					if (aux == 1) {
						System.out.println("Chave incluida com sucesso.");
					}
					break;
				case 3:
					System.out.println("Digite a chave a ser excuida");
					r = ler.next();
					aux = obj.excluir(r);
					if (aux == 1) {
						System.out.println("Chave excluida.");
					}
					break;
				case 9:
					verific = 0;
					break;
				default:
					
			}
		}
	}
}
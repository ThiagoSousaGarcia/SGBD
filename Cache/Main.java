import java.util.*;
public class Main {
	public static void main(String[] args) {
		/*int valor;
		int verificador = 1;
		Scanner ler = new Scanner(System.in);

		while(verificador == 1){
	    	
	    	System.out.println("1 - LRU\n");
	    	System.out.println("2 - FIFO\n");
	    	System.out.println("3 - CLOCK\n");
	    	System.out.println("4 - MRU\n");
	    	System.out.println("5 - Random Replace\n");
	    	System.out.println("6 - LFU\n");
	    	System.out.println("9 - Sair\n");

	    	System.out.println("Informe a politica a ser usada:\n");
	    	int politica = ler.nextInt();

	    	switch(politica){
	    		case 1:
	    			LRU obj1 = new LRU();
	    			verificador = 0;

				   	while(verificador == 0){
				    	
				    	System.out.println("1 - Fetch(int key)\n");
				    	System.out.println("2 - DisplayCache()\n");
				    	System.out.println("3 - DisplayStats()\n");
				    	System.out.println("9 - Sair\n");

				    	System.out.println("Informe o metodo a ser usado:\n");
				    	int escolha = ler.nextInt();

				    	switch(escolha){
				    		case 1:

				    			int verific = 1;
				    			while(verific == 1){
					    			System.out.println("Informe a chave:\n");
					    			valor = ler.nextInt();
					    			obj1.Fetch(valor);
					    			System.out.println("Busca realizada!\n");
					    			System.out.printf("Deseja buscar outra chave?(Y/n)\n");
				    				String resposta = ler.next();
				    				if(resposta != "Y" || resposta != "y"){
				    					verific = 0;
				    				}else{
				    					System.out.print("\033\143");
				    				}
				    			}

				    			break;
				    		case 2:
				    			obj1.DisplayCache();
				    			System.out.printf("Aperte qualquer tecla para voltar.\n");
				    			valor = ler.nextInt();
				    			break;
				    		case 3:
				    			obj1.DisplayStats();
				    			System.out.printf("Aperte qualquer tecla para voltar.\n");
				    			valor = ler.nextInt();
				    			break;	
				    		case 9:
				    			verificador = 9;
				    			break;
				    		default:
				    			System.out.println("Comando não encontrado.");
				    			break;
				    	}
				    	System.out.print("\033\143");
				    }

	    			break;
	    		case 2:
	    			FIFO obj2 = new FIFO();
	    			verificador = 0;

    				while(verificador == 0){
			    	
				    	System.out.println("1 - Fetch(int key)\n");
				    	System.out.println("2 - DisplayCache()\n");
				    	System.out.println("3 - DisplayStats()\n");
				    	System.out.println("9 - Sair\n");

				    	System.out.println("Informe o metodo a ser usado:\n");
				    	int escolha = ler.nextInt();

				    	switch(escolha){
				    		case 1:

				    			int verific = 1;
				    			while(verific == 1){
					    			System.out.println("Informe a chave:\n");
					    			valor = ler.nextInt();
					    			obj2.Fetch(valor);
					    			System.out.println("Busca realizada!\n");
					    			System.out.printf("Deseja buscar outra chave?(Y/n)\n");
				    				String resposta = ler.next();
				    				if(resposta != "Y" || resposta != "y"){
				    					verific = 0;
				    				}else{
				    					System.out.print("\033\143");
				    				}
				    			}

				    			break;
				    		case 2:
				    			obj2.DisplayCache();
				    			System.out.printf("Aperte qualquer tecla para voltar.\n");
				    			valor = ler.nextInt();
				    			break;
				    		case 3:
				    			obj2.DisplayStats();
				    			System.out.printf("Aperte qualquer tecla para voltar.\n");
				    			valor = ler.nextInt();
				    			break;	
				    		case 9:
				    			verificador = 9;
				    			break;
				    		default:
				    			System.out.println("Comando não encontrado.");
				    			break;
				    	}
				    	System.out.print("\033\143");
			   		 }


	    			break;
	    		case 3:
	    			CLOCK obj3 = new CLOCK();
	    			verificador = 0;

	    			while(verificador == 0){
			    	
				    	System.out.println("1 - Fetch(int key)\n");
				    	System.out.println("2 - DisplayCache()\n");
				    	System.out.println("3 - DisplayStats()\n");
				    	System.out.println("9 - Sair\n");

				    	System.out.println("Informe o metodo a ser usado:\n");
				    	int escolha = ler.nextInt();

				    	switch(escolha){
				    		case 1:

				    			int verific = 1;
				    			while(verific == 1){
					    			System.out.println("Informe a chave:\n");
					    			valor = ler.nextInt();
					    			obj3.Fetch(valor);
					    			System.out.println("Busca realizada!\n");
					    			System.out.printf("Deseja buscar outra chave?(Y/n)\n");
				    				String resposta = ler.next();
				    				if(resposta != "Y" || resposta != "y"){
				    					verific = 0;
				    				}else{
				    					System.out.print("\033\143");
				    				}
				    			}

				    			break;
				    		case 2:
				    			obj3.DisplayCache();
				    			System.out.printf("Aperte qualquer tecla para voltar.\n");
				    			valor = ler.nextInt();
				    			break;
				    		case 3:
				    			obj3.DisplayStats();
				    			System.out.printf("Aperte qualquer tecla para voltar.\n");
				    			valor = ler.nextInt();
				    			break;	
				    		case 9:
				    			verificador = 9;
				    			break;
				    		default:
				    			System.out.println("Comando não encontrado.");
				    			break;
				    	}
				    	System.out.print("\033\143");
			   		}

	    			break;	
	    		case 4:
	    			MRU obj4 = new MRU();
	    			verificador = 0;

					while(verificador == 0){

						System.out.println("1 - Fetch(int key)\n");
						System.out.println("2 - DisplayCache()\n");
						System.out.println("3 - DisplayStats()\n");
						System.out.println("9 - Sair\n");

						System.out.println("Informe o metodo a ser usado:\n");
						int escolha = ler.nextInt();

						switch(escolha){
							case 1:

								int verific = 1;
								while(verific == 1){
					    			System.out.println("Informe a chave:\n");
					    			valor = ler.nextInt();
					    			obj4.Fetch(valor);
					    			System.out.println("Busca realizada!\n");
					    			System.out.printf("Deseja buscar outra chave?(Y/n)\n");
									String resposta = ler.next();
									if(resposta != "Y" || resposta != "y"){
										verific = 0;
									}else{
										System.out.print("\033\143");
									}
								}

								break;
							case 2:
								obj4.DisplayCache();
								System.out.printf("Aperte qualquer tecla para voltar.\n");
								valor = ler.nextInt();
								break;
							case 3:
								obj4.DisplayStats();
								System.out.printf("Aperte qualquer tecla para voltar.\n");
								valor = ler.nextInt();
								break;	
							case 9:
								verificador = 9;
								break;
							default:
								System.out.println("Comando não encontrado.");
								break;
						}
						System.out.print("\033\143");
					}


	    			break;
	    		case 5:
	    			RandomRep obj5 = new RandomRep();
	    			verificador = 0;

	    			while(verificador == 0){

						System.out.println("1 - Fetch(int key)\n");
						System.out.println("2 - DisplayCache()\n");
						System.out.println("3 - DisplayStats()\n");
						System.out.println("9 - Sair\n");

						System.out.println("Informe o metodo a ser usado:\n");
						int escolha = ler.nextInt();

						switch(escolha){
							case 1:

								int verific = 1;
								while(verific == 1){
					    			System.out.println("Informe a chave:\n");
					    			valor = ler.nextInt();
					    			obj5.Fetch(valor);
					    			System.out.println("Busca realizada!\n");
					    			System.out.printf("Deseja buscar outra chave?(Y/n)\n");
									String resposta = ler.next();
									if(resposta != "Y" || resposta != "y"){
										verific = 0;
									}else{
										System.out.print("\033\143");
									}
								}

								break;
							case 2:
								obj5.DisplayCache();
								System.out.printf("Aperte qualquer tecla para voltar.\n");
								valor = ler.nextInt();
								break;
							case 3:
								obj5.DisplayStats();
								System.out.printf("Aperte qualquer tecla para voltar.\n");
								valor = ler.nextInt();
								break;	
							case 9:
								verificador = 9;
								break;
							default:
								System.out.println("Comando não encontrado.");
								break;
						}
						System.out.print("\033\143");
					}
	    			break;
	    		case 6:
	    			LFU obj6 = new LFU();
	    			verificador = 0;

	    			while(verificador == 0){

						System.out.println("1 - Fetch(int key)\n");
						System.out.println("2 - DisplayCache()\n");
						System.out.println("3 - DisplayStats()\n");
						System.out.println("9 - Sair\n");

						System.out.println("Informe o metodo a ser usado:\n");
						int escolha = ler.nextInt();

						switch(escolha){
							case 1:

								int verific = 1;
								while(verific == 1){
					    			System.out.println("Informe a chave:\n");
					    			valor = ler.nextInt();
					    			obj6.Fetch(valor);
					    			System.out.println("Busca realizada!\n");
					    			System.out.printf("Deseja buscar outra chave?(Y/n)\n");
									String resposta = ler.next();
									if(resposta != "Y" || resposta != "y"){
										verific = 0;
									}else{
										System.out.print("\033\143");
									}
								}

								break;
							case 2:
								obj6.DisplayCache();
								System.out.printf("Aperte qualquer tecla para voltar.\n");
								valor = ler.nextInt();
								break;
							case 3:
								obj6.DisplayStats();
								System.out.printf("Aperte qualquer tecla para voltar.\n");
								valor = ler.nextInt();
								break;	
							case 9:
								verificador = 9;
								break;
							default:
								System.out.println("Comando não encontrado.");
								break;
						}
						System.out.print("\033\143");
					}

	    			break;
	    		case 9:
	    			verificador = 9;
	    			break;
	    		default:
	    			System.out.println("Comando não encontrado.");
	    			break;
	    	}
	    	System.out.print("\033\143");
	    }*/

		
	    LRU obj = new LRU();
		

		obj.Fetch(24);
		obj.Fetch(18);
		obj.Fetch(2);
		obj.Fetch(21);
		obj.Fetch(9);
		obj.Fetch(5);
		obj.Fetch(13);
		obj.Fetch(22);
		obj.Fetch(2);
		obj.Fetch(9);
		obj.Fetch(18);
		obj.Fetch(12);
		obj.Fetch(16);
		obj.Fetch(7);
		obj.Fetch(5);
		obj.Fetch(14);
		obj.Fetch(13);
		obj.Fetch(14);
		obj.Fetch(13);
		obj.Fetch(22);
		obj.Fetch(23);

		/*
		obj.Fetch(1);
		obj.Fetch(5);
		obj.Fetch(6);
		obj.Fetch(13);
		obj.Fetch(1);
		obj.Fetch(4);
		obj.Fetch(8);
		obj.Fetch(13);
		obj.Fetch(9);
		obj.Fetch(10);
		obj.Fetch(15);
		obj.Fetch(5);
		obj.Fetch(4);
		obj.Fetch(4);
		obj.Fetch(4);
		obj.Fetch(6);
		obj.Fetch(16);*/
		
		obj.DisplayCache();
		obj.DisplayStats();
	}
}
import java.io.*;
import java.util.*;
import java.lang.*;

public class Hash {

	public Hash(){};

	public String buscar(String chave){
		try{
			FileReader arquivo = new FileReader("index.txt");
			BufferedReader lerArq = new BufferedReader(arquivo);
			String profundidade = lerArq.readLine();
			int profGlobal = Integer.parseInt(profundidade.substring(2,3));//Ler Profundidade Global
			//Converter para binario
			int aux = chave.hashCode();
			String key = Integer.toBinaryString(aux);
			
			//Busca
			String linha = lerArq.readLine();
			int profLocal = 0;//Ler Profundidade Local
			String index = null;
			while (linha != null) {
				if(linha.charAt(0) == '*'){
					profLocal = Integer.parseInt(linha.substring(1,2));
					index = key.substring((key.length() - profLocal), key.length());
				}
				else if (linha.equals(index)) {
					for (int i = 0; i < profLocal+1; i++) {
						linha = lerArq.readLine();
						if(linha == null){
							return null;
						}else if(linha.equals(key)){
							arquivo.close();
							FileReader arq = new FileReader("BD.txt");
							BufferedReader ler = new BufferedReader(arq);
							String l = ler.readLine();
							while (l != null) {
								aux = l.hashCode();
								String value = Integer.toBinaryString(aux);
								if(value.equals(key)){
									arquivo.close();
									return l;
								}
								l = ler.readLine();
							}
						}	
					}
					return null;
				}
				linha = lerArq.readLine();
			}
		}	
		catch(IOException e){
			System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
		}
		return null;
	}

	public int incluir(String chave){
		try{
			FileReader arquivo = new FileReader("index.txt");
			BufferedReader lerArq = new BufferedReader(arquivo);
			String profundidade = lerArq.readLine();
			int profGlobal = Integer.parseInt(profundidade.substring(2,3));//Ler Profundidade Global
			//Converter para binario
			int aux = chave.hashCode();
			String key = Integer.toBinaryString(aux);
			
			//Busca
			String linha = lerArq.readLine();
			int profLocal = 0;
			String index = null;
			while (linha != null) {
				if(linha.charAt(0) == '*'){
					profLocal = Integer.parseInt(linha.substring(1,2));//Ler Profundidade Local
					index = key.substring((key.length() - profLocal), key.length());
				}
				else if (linha.equals(index)) {
					for (int i = 0; i < 2 ; i++) {
						linha = lerArq.readLine();
						if(linha.equals("-1")){
							this.incluir_linha(chave, key, index);
							return 1;
						}
					}
					this.dividir_bucket(chave, key, index, profLocal, profGlobal);
					return 1;
				}
				linha = lerArq.readLine();
			}
		}	
		catch(IOException e){
			System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
		}

		return 0;
	}

	public void incluir_linha(String elemento, String key, String index) throws IOException {
	    //Adicionando no index.txt
	    String arquivo = "index.txt";
	    String arquivoTmp = "index-tmp.txt";

	    BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
	    BufferedReader reader = new BufferedReader(new FileReader(arquivo));

	    String linha;
	    while ((linha = reader.readLine()) != null) {
	        writer.write(linha + "\n");
	        if(linha.equals(index)){
	        	linha = reader.readLine();
	        	if (linha.equals("-1")) {
	        		writer.write(key + "\n");
	        	}else{
	        		writer.write(linha + "\n");
	        		linha = reader.readLine();
	        		writer.write(key + "\n");	
	        	}
	        	
	        }
	    }

	    writer.close();        
	    reader.close();

	    new File(arquivo).delete();
	    new File(arquivoTmp).renameTo(new File(arquivo));

	    //Adicionando no BD.txt
	    BufferedWriter wtr = new BufferedWriter(new FileWriter("BD.txt", true));
	    wtr.write(elemento);
	    wtr.newLine();
        wtr.flush();
        wtr.close();

	}

	public void dividir_bucket(String elemento, String key, String index, int local, int global){
		String value1, value2, value3, pag1, pag2;
		
		if (local == global) {
			global = global + 1;
		}
		local = local + 1;

		value3 = key.substring((key.length() - local), key.length());

		String index1 = "0"+index;
		String index2 = "1"+index;

		try{
			//Adicionando no index.txt
		    String arquivo = "index.txt";
		    String arquivoTmp = "index-tmp.txt";

		    BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
		    BufferedReader reader = new BufferedReader(new FileReader(arquivo));

		    String linha;

		    writer.write("**"+Integer.toString(global) + "\n");//Mudando Profundidade Global
		    linha = reader.readLine();
		    while ((linha = reader.readLine()) != null) {
		        if(linha.charAt(0) == '*'){
					int pLocal = Integer.parseInt(linha.substring(1,2));
					linha = reader.readLine();
				}
				if (linha.equals(index)) {
					writer.write("*"+Integer.toString(local) + "\n");//Mudando Profundidade Local
					writer.write(index1 + "\n");//Adicionando primeiro index novo
					linha = reader.readLine();
					pag1 = linha;
					value1 = linha.substring((linha.length() - local), linha.length());
					linha = reader.readLine();
					pag2 = linha;
					value2 = linha.substring((linha.length() - local), linha.length());
					//Tratando caso de overflow
					if (index1.equals(value1) && index1.equals(value2) && index1.equals(value3)) {
						writer.write(pag1 + "\n");
						writer.write(pag2 + "\n");
						writer.write(key + "\n");
						writer.write("*"+Integer.toString(local) + "\n");//Mudando Profundidade Local
						writer.write(index2 + "\n");//Adicionando segundo index novo
						writer.write("-1\n");
						writer.write("-1\n");
					}else if (index2.equals(value1) && index2.equals(value2) && index2.equals(value3)) {
						writer.write("-1\n");
						writer.write("-1\n");
						writer.write("*"+Integer.toString(local) + "\n");//Mudando Profundidade Local
						writer.write(index2 + "\n");//Adicionando segundo index novo
						writer.write(pag1 + "\n");
						writer.write(pag2 + "\n");
						writer.write(key + "\n");
					}else{
						int verficador = 0;
						if (index1.equals(value1)) {
							writer.write(pag1 + "\n");
						}else if(verficador == 0){
							writer.write("-1\n");
							verficador = 1;
						}

						if (index1.equals(value2)) {
							writer.write(pag2 + "\n");
						}else if(verficador == 0){
							writer.write("-1\n");
							verficador = 1;
						}

						if (index1.equals(value3)) {
							writer.write(key + "\n");
						}else if(verficador == 0){
							writer.write("-1\n");
							verficador = 1;
						}

						writer.write("*"+Integer.toString(local) + "\n");//Mudando Profundidade Local
						writer.write(index2 + "\n");//Adicionando segundo index novo
						
						verficador = 0;

						if (index2.equals(value1)) {
							writer.write(pag1 + "\n");
						}else if(verficador == 0){
							writer.write("-1\n");
							verficador = 1;
						}

						if (index2.equals(value2)) {
							writer.write(pag2 + "\n");
						}else if(verficador == 0){
							writer.write("-1\n");
							verficador = 1;
						}

						if (index2.equals(value3)) {
							writer.write(key + "\n");
						}else if(verficador == 0){
							writer.write("-1\n");
							verficador = 1;
						}

					}
				}else{
					writer.write(linha + "\n");
				}
		    }

		    writer.close();        
		    reader.close();

		    new File(arquivo).delete();
		    new File(arquivoTmp).renameTo(new File(arquivo));

		    //Adicionando no BD.txt
		    BufferedWriter wtr = new BufferedWriter(new FileWriter("BD.txt", true));
		    wtr.write(elemento);
		    wtr.newLine();
	        wtr.flush();
	        wtr.close();
		}
		catch(IOException e){
			System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
		}
	}


	public int excluir(String chave){

		int aux = chave.hashCode();
		String key = Integer.toBinaryString(aux);

		try{
			//Removendo no index.txt
		    String arquivo = "index.txt";
		    String arquivoTmp = "index-tmp.txt";

		    BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
		    BufferedReader reader = new BufferedReader(new FileReader(arquivo));

		    String linha;

		    while ((linha = reader.readLine()) != null) {
		        if(linha.equals(key)){
		        	writer.write("-1\n");
		        	linha = reader.readLine();
		        }
		        writer.write(linha + "\n");
		    }


		    writer.close();        
		    reader.close();

		    new File(arquivo).delete();
		    new File(arquivoTmp).renameTo(new File(arquivo));

		    //Removendo no BD.txt
		    String arq = "BD.txt";
		    String arqTmp = "BD-tmp.txt";

		    BufferedWriter w = new BufferedWriter(new FileWriter(arqTmp));
		    BufferedReader r = new BufferedReader(new FileReader(arq));


		    String l;

		    while ((l = r.readLine()) != null) {
		        if(!l.equals(chave)){
		        	w.write(l + "\n");
		        }
		    }

		    w.close();        
		    r.close();

		    new File(arq).delete();
		    new File(arqTmp).renameTo(new File(arq));

		    return 1;

		}
		catch(IOException e){
			System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
		}
		
		return 0;
	}
}
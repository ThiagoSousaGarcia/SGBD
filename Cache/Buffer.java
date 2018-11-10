import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



abstract class Buffer {
	
	public Map<Integer,String> buffer = new LinkedHashMap<Integer,String>();
	int hit = 0,miss = 0;

	public Buffer(){};

	abstract void Fetch(int key);

	abstract int Evict();

	public void inserir(int key){
		try{
			FileReader arquivo = new FileReader("arquivo.txt");
			BufferedReader lerArq = new BufferedReader(arquivo);

			String linha = null;

			for (int i=0;i < key; i++) {
				linha = lerArq.readLine();
			}

			this.buffer.put(key,linha);
		
		}	
		catch(IOException e){
			System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
		}
	}
	
	abstract void DisplayCache();

	public void DisplayStats(){
		System.out.printf("Cache Hit -> %d\n",this.hit);
		System.out.printf("Cache Miss -> %d\n",this.miss);
	}

}
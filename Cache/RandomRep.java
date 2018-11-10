import java.util.*;

class RandomRep extends Buffer {

	void Fetch(int key){

		String dado;

		dado = buffer.get(key);

		if(dado == null){
			if(buffer.size() == 8){
				Evict();
			}else{
				inserir(key);
			}
			this.miss++;
		}else{
			this.hit++;
		}

	}

	int Evict(){
		Random gerador = new Random();
		ArrayList<Integer> chaves = new ArrayList<>(this.buffer.keySet());
        int numero = gerador.nextInt(8);
        int chave;
        
        chave = chaves.get(numero);
 
        buffer.remove(chave);

        return chave;
	}

	public void DisplayCache(){
		ArrayList<Integer> chaves = new ArrayList<>(this.buffer.keySet());

		for (int i=0;i<chaves.size();i++){
			System.out.printf("Chave--> %d,Valor--> %s \n",chaves.get(i),this.buffer.get(chaves.get(i)));			
		}
	}
}
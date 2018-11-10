import java.util.*;

class FIFO extends Buffer {

	void Fetch(int key){

		String dado;

		dado = buffer.get(key);

		if(dado == null){
			if(buffer.size() == 8){
				Evict();
			}
			inserir(key);
			this.miss++;
		}else{
			this.hit++;
		}
	}

	int Evict(){
		ArrayList<Integer> chaves = new ArrayList<>(this.buffer.keySet());
        
        int chave = chaves.get(0);
 
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
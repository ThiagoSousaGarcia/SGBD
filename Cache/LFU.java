import java.util.*;

class LFU extends Buffer {
	public Map<Integer,Integer> frequencia = new LinkedHashMap<Integer,Integer>();

	void Fetch(int key){

		String dado;

		dado = buffer.get(key);

		if(dado == null){
			if(buffer.size() == 8){
				Evict();
			}
			inserir(key);
			this.frequencia.put(key,1);
			this.miss++;
		}else{
			int freq = this.frequencia.get(key)+1;
			this.frequencia.remove(key);
			this.frequencia.put(key,freq);
			this.hit++;
		}
	}

	int Evict(){
		ArrayList<Integer> chaves = new ArrayList<>(this.buffer.keySet());
        ArrayList<Integer> qtd_freq = new ArrayList<>(this.frequencia.keySet());

        int posicao = 0;
        int menor = this.frequencia.get(qtd_freq.get(posicao));
        for (int i = 1; i < qtd_freq.size(); i++) {
        	if (menor > this.frequencia.get(qtd_freq.get(i))) {
        		menor = this.frequencia.get(qtd_freq.get(i));
        		posicao = i;
        	}
        }

        int chave = qtd_freq.get(posicao);
 
        buffer.remove(chave);
    	this.frequencia.remove(chave);

        return chave;

	}

	public void DisplayCache(){
		ArrayList<Integer> chaves = new ArrayList<>(this.buffer.keySet());

		for (int i = 0; i < chaves.size(); i++){
			System.out.printf("Chave--> %d,Valor--> %s \n",chaves.get(i),this.buffer.get(chaves.get(i)));			
		}
	}
}
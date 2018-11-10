import java.util.*;

class CLOCK extends Buffer {
	Map<Integer,Integer> r = new LinkedHashMap<Integer,Integer>();
	int[] chaves_ordenadas = new int[8];
	int posicao, matriz_pos;

	public CLOCK(){
		this.posicao = 0;
		this.matriz_pos = 0;
	}

	void Fetch(int key){
		String dado;

		dado = buffer.get(key);

		if(dado == null){
			if(buffer.size() == 8){
				int retorno = Evict();
				chaves_ordenadas[retorno] = key;
				inserir(key);
				this.r.put(key,0);
			}else{
				inserir(key);
				this.r.put(key,0);
				chaves_ordenadas[matriz_pos] = key;
				this.matriz_pos++;
			}
			this.miss++;
		}else{
			this.r.remove(key);
			this.r.put(key,1);
			this.hit++;
		}
	}

	int Evict(){
		int achou = 1;
		while(achou == 1){
			if(this.r.get(chaves_ordenadas[posicao]) == 0){
				achou = 0;
				buffer.remove(chaves_ordenadas[posicao]);
			}else{
				this.r.remove(chaves_ordenadas[posicao]);
				this.r.put(chaves_ordenadas[posicao], 0);
			}
			this.posicao++;
			if(posicao == 8){
				this.posicao = 0;
				return posicao;
			}
		}

		return posicao - 1;
	}

	public void DisplayCache(){
		for (int i = 0; i < 8; i++) {
			System.out.printf("Chave--> %d,Valor--> %s \n",chaves_ordenadas[i],this.buffer.get(chaves_ordenadas[i]));
		}
	}
}
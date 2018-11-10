import java.util.*;
import java.text.SimpleDateFormat;
import java.lang.Thread;

public class Lock_Manager {
	

	Map<Integer,Integer> lock_table_transaction = new HashMap<Integer,Integer>();
	Map<Integer,String> lock_table_lock = new HashMap<Integer,String>();
	
	Queue<Map<Integer,String>> wait_Q = new LinkedList<Map<Integer,String>>();
	Map<Integer,String> auxiliar = new HashMap<Integer,String>();
	//Map<String,String> auxiliar1 = new HashMap<String,String>();


	public void LS(int id_transacao, Item item){
		
		int verificador = 0;

		try {
			Thread.sleep(1000);
		}catch (Exception e) {
		  	e.printStackTrace();
		}

		if (item.transacao_e_tipo.isEmpty()){
				lock_table_lock.put(item.id,"S");
				lock_table_transaction.put(item.id,id_transacao);
				item.transacao_e_tipo.put(id_transacao,"S");
				System.out.println("Bloqueio S(exclusivo) da transação " + id_transacao + " no item " + item.id + "  concedido");
				String novaTS = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
				item.transacao_e_ts.put(id_transacao,novaTS);

				
		}else{
			for (Map.Entry<Integer,String> entrada : item.transacao_e_tipo.entrySet()) {
				String c = entrada.getValue();
				if(c == "X"){
					verificador = 1;
				}
			}
			if (verificador == 1) {
				Map<Integer,String> auxiliar = new HashMap<Integer,String>();
				auxiliar.put(id_transacao,"S");
				wait_Q.add(auxiliar);
				System.out.println("Bloqueio S(compartilhado) da transação " + id_transacao  + " no item " + item.id +" não concedido");
			}else{
				lock_table_lock.put(item.id,"S");
				lock_table_transaction.put(item.id,id_transacao);
				item.transacao_e_tipo.put(id_transacao,"S");
				System.out.println("Bloqueio S(exclusivo) da transação " + id_transacao +" no item " + item.id + "  concedido");
				String novaTS = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
				item.transacao_e_ts.put(id_transacao,novaTS);
			}
		}
	}

	public void LX(int id_transacao, Item item){


		try {
			Thread.sleep(1000);
		}catch (Exception e) {
			e.printStackTrace();
		}

		if (item.transacao_e_tipo.isEmpty()){
				lock_table_lock.put(item.id,"X");
				lock_table_transaction.put(item.id,id_transacao);
				item.transacao_e_tipo.put(id_transacao,"X");
				System.out.println("Bloqueio X(exclusivo) da transação " + id_transacao + " no item " + item.id +"  concedido");
				String novaTS = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
				item.transacao_e_ts.put(id_transacao,novaTS);

				
				
		}else{
			Map<Integer,String> auxiliar = new HashMap<Integer,String>();
			auxiliar.put(id_transacao,"X");
			wait_Q.add(auxiliar);
			System.out.println("Bloqueio X(exclusivo) da transação " + id_transacao + " no item " + item.id +" não concedido");
		}



	}

	public void U(int id_transacao, Item item){

		lock_table_lock.remove(item.id);
		lock_table_transaction.remove(item.id);
	}

	public void Wait_Die(int id_transacao, Item item, String tipo){ 
		

		Map<Integer,String> lista_tr_ts = item.transacao_e_ts;

		System.out.println(lista_tr_ts.size());

		boolean vazio = lista_tr_ts.isEmpty();
		String timeStamp = null;
		
		if (!(vazio)) {
			for (Integer entrada : item.transacao_e_ts.keySet()) {
				if(entrada == id_transacao){
					timeStamp = item.transacao_e_ts.get(entrada);
				}				
			}

			if (timeStamp != null){
				for (Integer entrada : item.transacao_e_ts.keySet()){ 
					if(entrada != id_transacao){
						if (timeStamp.compareTo(item.transacao_e_ts.get(entrada)) < 0){ 
							Map<Integer,String> auxiliar = new HashMap<Integer,String>();
							auxiliar.put(id_transacao,tipo);
							wait_Q.add(auxiliar);
							System.out.println("Jogando na Fila de wait_Q em Wait_Die da transacao "+ id_transacao);
						}else{
							String novaTS = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
							item.transacao_e_ts.put(id_transacao,novaTS);
							System.out.println("Transação "+ id_transacao + " abortada");
						}
					}
				}
			}
		}
	}
	



}




import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.Thread;

public class Tr_Manager extends Transacao{


	int tr = 0;




	public void criar_transacao(int tr_id){

		this.id = tr_id;
		//this.ts = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		tr = tr + 1; 
		this.status = 0;
		
		//System.out.println(ts);
		/*try {
	   		Thread.sleep(1000);
		}catch (Exception e) {
	  		 e.printStackTrace();
		}*/


		//System.out.println("Time Stamp - "+this.ts);
		//System.out.println("Tr " + tr);
		//System.out.println("Status " + this.status);
	}


	public void finalizar_transacao(int id_tr, Item item){
		this.status = 1;
		item.transacao_e_tipo.remove(id_tr);
	}

	

}



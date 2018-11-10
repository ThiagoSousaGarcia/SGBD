public class Main  {
	
	public static void main(String[] args) {
		
		


		Tr_Manager T1 = new Tr_Manager();
		Lock_Manager L1 = new Lock_Manager();
		
		

		Item x = new Item(1);
		Item y = new Item(2);
		Item z = new Item(3);
		
		
		T1.criar_transacao(1);
		L1.LS(1,x);
		T1.criar_transacao(2);
		L1.LX(2,x);
		L1.LS(2,y);
		L1.LX(1,y);
		T1.finalizar_transacao(1,x);
		T1.finalizar_transacao(1,y);
		L1.LS(2,z);
		T1.finalizar_transacao(2,x);
		T1.finalizar_transacao(2,y);
		T1.finalizar_transacao(2,z);
		




	}


}



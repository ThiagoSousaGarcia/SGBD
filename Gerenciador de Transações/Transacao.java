import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;




public abstract class Transacao {
	
	int id;
	String ts;
	int status;
	String tipo;
	Queue<Transacao> wait_for = new LinkedList<Transacao>();  

	public abstract void criar_transacao(int id_trans);
	public abstract void finalizar_transacao(int id_trans, Item item);

}
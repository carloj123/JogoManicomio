package JogoDemo.Ferramentas;

import ClassesBasicas.Ferramenta;

import java.util.Random;

public class LockPick extends Ferramenta {
	

	private final int QTD_MAX_FALHA = 3;

	private int qtdFalhas;

	private boolean estaQuebrado;

	Random gerador = new Random();

	public LockPick() {
		super("Grampo");
		this.qtdFalhas = 0;
		estaQuebrado = false;
	}
	
	public boolean abrir() {
		int chance = gerador.nextInt(20)+1;
		if(chance != 5 || chance != 7) {
			return super.usar();
		}
		else {
			qtdFalhas++;
			if(qtdFalhas == QTD_MAX_FALHA)
					estaQuebrado = true;
			return false;
		}
	}

	public boolean estaQuebrado(){
		return estaQuebrado;
	}
		

	

	public int getQtdFalhas() {
		return qtdFalhas;
	}

	
}
